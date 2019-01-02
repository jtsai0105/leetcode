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
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> backMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        
        TreeNode kNode = DFS(root, k, backMap);
        queue.add(kNode);
        
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            visited.add(cur);
            if (cur.left == null && cur.right == null) {
                return cur.val;
            }
            
            if (cur.left != null && !visited.contains(cur.left)) {
                queue.offer(cur.left);
            }
            
            if (cur.right != null && !visited.contains(cur.right)) {
                queue.offer(cur.right);
            }
            
            TreeNode backNode = backMap.get(cur);
            if (backNode != null && !visited.contains(backNode)) {
                queue.offer(backNode);
            }
        }
        
        return -1; // Should never reach this state
    }
    
    private TreeNode DFS(TreeNode root, int k, Map<TreeNode, TreeNode> backMap) {
        if(root.val == k) {
            return root;
        }
        if(root.left != null) {
            backMap.put(root.left, root);
            TreeNode left = DFS(root.left, k, backMap);
            if(left != null) return left;
        }
        if(root.right != null) {
            backMap.put(root.right, root);
            TreeNode right = DFS(root.right, k, backMap);
            if(right != null) return right;
        }
        return null;
    }
}
