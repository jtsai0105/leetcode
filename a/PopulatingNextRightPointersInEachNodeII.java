/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = root;
        while (head != null) {
            TreeLinkNode nextHead = new TreeLinkNode(0), nextTail = nextHead;
            for (TreeLinkNode node = head; node != null; node = node.next) {
                if (node.left != null) {
                    nextTail.next = node.left;
                    nextTail = node.left;
                }
                if (node.right != null) {
                    nextTail.next = node.right;
                    nextTail = node.right;
                }
            }
            head = nextHead.next;
        }
    }
}
