public class Solution {
    Hit start = new Hit(0);
    int count = 0;
    Hit tail = start;
    
    public void hit(int timestamp) {
        if(tail.timestamp == timestamp) {
            tail.count++;
        } else {
            tail.next = new Hit(timestamp);
            tail = tail.next;
        }
        count++;
    }
    
    public int getHits(int timestamp) {
        while(start.next != null && timestamp-start.next.timestamp >= 300) {
            count -= start.next.count;
            start.next = start.next.next;
        }
        if(start.next == null)
            tail = start;
        return count;
    }
}

class Hit {
    int timestamp;
    int count;
    Hit next;
    Hit(int timestamp) {
        this.timestamp = timestamp;
        this.count = 1;
    }
}
