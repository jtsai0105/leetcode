/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        pushLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            pushLeft(tmp.right, stack);
        }
        return res;
    }
    
    private void pushLeft(TreeNode root, Stack stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    } 
}
