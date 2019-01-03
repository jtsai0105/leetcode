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
    private TreeNode result;
    private TreeNode pre;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;   
        increasingBST(root.left);  
        if (pre != null) { 
        	root.left = null;
        	pre.right = root; 
        }
        if (result == null) result = root;
        pre = root;
        increasingBST(root.right); 
        return result;
    }
}
