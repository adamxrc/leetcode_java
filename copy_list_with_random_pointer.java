/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode fake = new RandomListNode(0);
        RandomListNode src = head;
        RandomListNode target = fake;
        
        while(src != null) {
            RandomListNode node = new RandomListNode(src.label);
            map.put(src, node);
            target.next = node;
            src = src.next;
            target = target.next;
        }
        
        src = head;
        while(src != null) {
            if(src.random != null) {
                RandomListNode from = map.get(src);
                RandomListNode to = map.get(src.random);
                from.random = to;
            }
            src = src.next;
        }
        
        return fake.next;
    }
}
