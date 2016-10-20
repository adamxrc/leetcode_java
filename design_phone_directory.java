public class PhoneDirectory {
	int max;
	Set<Integer> set;
	LinkedList<Integer> queue;
	
	public PhoneDirectory(int maxNumber) {
		set = new HashSet<Integer>();
		queue = new LinkedList<Integer>();
		for(int i = 0; i < maxNumber; i++)
			queue.offer(i);
		max = maxNumber - 1;
	}
	
	public int get() {
		if(queue.isEmpty())
			return -1;
		int e = queue.offer();
		set.add(e);
		return e;
	}
	
	public boolean check(int number) {
		return !set.contains(number) && number <= max;
	}
	
	public void release(int number) {
		if(set.contains(number)) {
			set.remove(number);
			queue.offer(number);
		}
	}
}
