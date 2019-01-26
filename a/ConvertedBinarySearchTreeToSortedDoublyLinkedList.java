/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    private Node head = new Node(0, null, null);
    private Node pre = head;
    
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inOrder(root);
        pre.right = head.right;
        head.right.left = pre;
        return head.right;
    }
    
    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        
        inOrder(root.left);
        pre.right = root;
        root.left = pre;
        pre = root;
        inOrder(root.right);
            
    }
}
