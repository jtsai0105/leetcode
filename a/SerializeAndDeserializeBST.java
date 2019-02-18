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
        if (root == null) {
            return "N,";
        }
        return String.valueOf(root.val) + "," + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> que = new LinkedList<>();
        que.addAll(Arrays.asList(data.split(",")));
        return buildTree(que);
    }
    
    private TreeNode buildTree(Queue<String> que) {
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
