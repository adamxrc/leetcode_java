public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		PriorityQueue<Interval> que = new PriorityQueue<Interval>(new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.end - i2.end;
			}
		});
		int rooms = 0;
		for(int i = 0; i < intervals.length; i++) {
			while(!que.isEmpty() && que.peek().end <= intervals[i].start)
				que.poll();
			que.offer(intervals[i]);
			rooms = Math.max(rooms, que.size());
		}
		return rooms;
    }
}
