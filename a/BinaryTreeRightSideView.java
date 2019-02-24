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
    private int max = -1;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }
    
    private void helper(TreeNode root, int depth, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        if (depth > max) {
            res.add(root.val);
            max = depth;
        }
        
        helper(root.right, depth + 1, res);
        helper(root.left, depth + 1, res);
    }
}
