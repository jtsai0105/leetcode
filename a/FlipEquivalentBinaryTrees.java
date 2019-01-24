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
    public boolean flipEquiv(TreeNode r1, TreeNode r2) {
        if (r1 == null || r2 == null) return r1 == r2;
        if (r1.val != r2.val) return false;
        return flipEquiv(r1.left, r2.left) && flipEquiv(r1.right, r2.right) || flipEquiv(r1.left, r2.right) && flipEquiv(r1.right, r2.left);
        
    }
}
