/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> que = new LinkedList<>();
        que.addAll(Arrays.asList(data.split(",")));
        return buildTree(que);
    }
    
    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        buildString(root.left, sb);
        buildString(root.right, sb);
    }
    
    private TreeNode buildTree(Queue<String> que) {
        if (que.isEmpty()) {
            return null;
        }
        String val = que.poll();
        if (val.equals("N")) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = buildTree(que);
        root.right = buildTree(que);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
