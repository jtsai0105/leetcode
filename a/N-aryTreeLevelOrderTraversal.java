/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            Node node;
            for (int i = queue.size(); i > 0; i--) {
                tmp.add(queue.peek().val);
                queue.addAll(queue.poll().children);
            }
            res.add(tmp);
        }
        return res;
    }
}
