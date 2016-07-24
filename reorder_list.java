public class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode cur = head;
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            ListNode n = stack.pop();
            if(cur != n) {
                ListNode temp = cur;
                cur = cur.next;
                temp.next = n;
                n.next = cur;
                if(cur.next == n) {
                    cur.next = null;
                    break;
                }
            } else {
                cur.next = null;
                break;
            }
        }
    }
}
