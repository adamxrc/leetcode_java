public class Vector2D {
	List<Iterator<Integer>> its;
	int curr = 0;
	
	public Vector2D(List<List<Integer>> vec2d) {
		its = new ArrayList<Iterator<Integer>>();
		for(List<Integer> l : vec2d) {
			if(l.size() > 0)
				its.add(l.iterator());
		}
	}
	
	public int next() {
		Integer res = its.get(curr).next();
		if(!its.get(curr).hasNext())
			curr++;
		return res;
	}
	
	public boolean hasNext() {
		return curr < its.size() && its.get(curr).hasNext();
	}
}
