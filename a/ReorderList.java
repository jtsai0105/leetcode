/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = reverse(slow.next);
        slow.next = null;
        ListNode cur = head;
        // 1->2->null;
        // 4->3->null;
        while (head2 != null) {
            ListNode tmp1 = head.next;
            ListNode tmp2 = head2.next;
            head.next = head2;
            
            if (tmp1 == null) {
                break;
            }
            head = tmp1;
            head2.next = head;
            head2 = tmp2;
        }
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        
        return pre;
    }
}
