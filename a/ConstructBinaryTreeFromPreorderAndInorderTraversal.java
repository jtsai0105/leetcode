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
    
    private int preIdx = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode dfs(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int val = preorder[preIdx];
        TreeNode root = new TreeNode(val);
        
        int inIdx = 0;
        for (int i = start; i <= end; i++) {
            if (val == inorder[i]) {
                inIdx = i;
                break;
            }
        }
        
        preIdx++;
        root.left = dfs(preorder, inorder, start, inIdx - 1);
        root.right = dfs(preorder, inorder, inIdx + 1, end);
        
        return root;
    }
}
