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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> backMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        constructBackMap(root, backMap, target);
        
        queue.offer(target);
        int distance = 0;
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            
            for (int i = queue.size(); i > 0; i--) {
                TreeNode cur = queue.poll();
                visited.add(cur.val);
                
                if (distance == K) {
                    res.add(cur.val);    
                }
                
                if (cur.left != null && !visited.contains(cur.left.val)) {
                    queue.offer(cur.left);
                }
                
                if (cur.right != null && !visited.contains(cur.right.val)) {
                    queue.offer(cur.right);
                }
                
                if (backMap.get(cur) != null && !visited.contains(backMap.get(cur).val)) {
                    queue.offer(backMap.get(cur));
                }
            }
            
            if (distance == K) {
                return res;
            }
                   
            distance++;
            
        }
        
        return res;
    }
    
    private void constructBackMap(TreeNode root, Map<TreeNode, TreeNode> backMap, TreeNode target) {
        if (root == null || root == target) {
            return;
        }
        
        if (root.left != null) {
            backMap.put(root.left, root);
        }
        
        if (root.right != null) {
            backMap.put(root.right, root);
        }
        
        constructBackMap(root.left, backMap, target);
        constructBackMap(root.right, backMap, target);
    }
}
