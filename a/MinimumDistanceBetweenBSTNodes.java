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
    
    public int minDiffInBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(root, inOrder);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < inOrder.size(); i++) {
            res = Math.min(res, inOrder.get(i) - inOrder.get(i - 1));
        }
        return res;
    }
    
    private void inOrderTraversal(TreeNode root, List<Integer> inOrder) {
        if (root == null) {
            return;
        }
    
        inOrderTraversal(root.left, inOrder);
        inOrder.add(root.val);
        inOrderTraversal(root.right, inOrder);
    }

}
