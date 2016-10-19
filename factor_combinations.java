public class Solution {
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		find(2, n, new ArrayList<>(), results);
		return results;
	}
	
	private void find(int from, int n, List<Integer> factors, List<List<Integer>> results) {
		for(int i = from; i * i <= n; i++) {
			if(n % i == 0) {
				factors.add(i);
				find(i, n/i, factors, results);
				factors.remove(factors.size()-1);
			}
		}
		
		if(!factors.isEmpty()) {
			factors.add(n);
			results.add(new ArrayList<>(factors));
			factors.remove(factors.size()-1);
		}
	}
}
