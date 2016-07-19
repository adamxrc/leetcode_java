/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode slow = fake;
        ListNode fast = fake;
        int count = 0;
        while(fast != null) {
            if(count == k) {
                ListNode start = slow.next;
                ListNode end = fast;
                fast = end.next;
                ListNode n = start;
                ListNode next = n.next;
                while(n != end) {
                    ListNode temp = next.next;
                    next.next = n;
                    n = next;
                    next = temp;
                }
                slow.next = end;
                start.next = fast;
                slow = start;
                fast = start;
                count = 0;
            } else {
                fast = fast.next;
                count++;
            }
        }
    }
}
