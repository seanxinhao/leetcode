/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        
        int i = 1;
        
        for (i = 1; i < m; i++) {
            if (curr == null) {
                return null;
            }
            curr = curr.next;
        }
        
        ListNode prev_m = curr;
        ListNode curr_m = curr.next;
        ListNode curr_n = curr_m;
        ListNode post_n = curr_m.next;
        
        for (i = m; i < n; i++) {
            if (post_n == null) {
                return null;
            }
            
            ListNode next = post_n.next;
            post_n.next = curr_n;
            curr_n = post_n;
            post_n = next;
        }
        
        
        curr_m.next = post_n;
        prev_m.next = curr_n;
        
        return dummy.next;
    }
}