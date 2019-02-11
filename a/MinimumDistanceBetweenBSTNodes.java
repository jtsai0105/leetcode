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
    int res = Integer.MAX_VALUE;
    Integer pre = null;
    public int minDiffInBST(TreeNode root) {
        inOrderTraversal(root);
        return res;
    }
    
    private void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
    
        inOrderTraversal(root.left);
        if (pre != null) {
            res = Math.min(res, root.val - pre);
        }
        pre = root.val;
        inOrderTraversal(root.right);
    }

}
