public class Solution {
	public List<String> findStrobogrammatic(int n) {
		List<String> results = new ArrayList<>();
		if(n == 0)
			return result;
		
		Map<Character, String>  = new HashMap<>();
		d.put('0', "0");
		d.put('1', "1");
		d.put('6', "6");
		d.put('8', "8");
		d.put('9', "9");
		String s = "01869";
		String result = "";
		int mid = n / 2;
		int oneMore = n % 2;
		
		recursion(d, results, result, s, mid, 0, oneMore);
		
		return results;
	}
	
	private void recursion(Map<Character, String> d, List<String> results, String result, String s, int recur, 
						   int iter, int oneMore) {
		if(iter > recur) {
			for(int i = 0; i < 3; i++)
				results.add(result.substring(0, recur) + s.charAt(i) + result.substring(recur));
			return;
		}
		
		if(iter == recur) {
			if(oneMore == 1) {
				recursion(d, results, result, s, recur, iter+1, oneMore);
			} else {
				results.add(result);
			}
			return;
		}
		
		if(iter == 0) {
			for(int i = 1; i < 5; i++) {
				recursion(d, results, s.charAt(i) + d.get(s.charAt(i)), s, recur, iter+1, oneMore);
			}
		} else {
			for(int i = 0; i < 5; i++) {
				recursion(d, results, result.substring(0, iter) + s.charAt(i) + d.get(s.charAt(i)) + result.substring(iter), 
						  s, recur, iter+1, oneMore);
			}
		}
	}
}
