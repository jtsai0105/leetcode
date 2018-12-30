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
    Map<Integer, List<TreeNode>> cache = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        if (N == 1) {
            return Arrays.asList(new TreeNode(0));
        }
        
        if (cache.containsKey(N)) {
            return cache.get(N);
        }
        
        List<TreeNode> res = new ArrayList<>();        
        N = N - 1;
        
        for(int i = 1; i < N; i += 2){
            List<TreeNode> lefts = allPossibleFBT(i);
            List<TreeNode> rights = allPossibleFBT(N-i);
            for(TreeNode left: lefts){
                for(TreeNode right:rights){
                    TreeNode cur = new TreeNode(0);
                    cur.left = left;
                    cur.right = right;
                    res.add(cur);
                }
            }
        }
        
        cache.put(N + 1, res);
        
        return res;
    }
}
