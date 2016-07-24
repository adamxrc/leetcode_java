public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode node = head;
        while(node != null) {
            stack.push(node);
            node = node.next;
        }
        k = k % stack.size();
        if(k == 0)
            return head;
        ListNode tail = stack.peek();
        for(int i = k; i > 0; i--)
            node = stack.pop();
        stack.peek().next = null;
        tail.next = head;
        return node;
    }
}
