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
    public int rob(TreeNode root) {
        Map<TreeNode, List<Integer>> map = new HashMap<>();
        map.put(null, Arrays.asList(0, 0));
        dfs(root, map);
        return Collections.max(map.get(root));
        
    }
    
    private void dfs(TreeNode root, Map<TreeNode, List<Integer>> map) {
        if (root == null) {
            return;
        }
        
        dfs(root.left, map);
        dfs(root.right, map);
        
        List<Integer> res = Arrays.asList(0, 0);
        // taken
        res.set(1, root.val + map.get(root.left).get(0) + map.get(root.right).get(0));
        // not taken
        res.set(0, Math.max(map.get(root.left).get(0), map.get(root.left).get(1)) + 
                    Math.max(map.get(root.right).get(0), map.get(root.right).get(1)));
        map.put(root, res);
        
    }
}
