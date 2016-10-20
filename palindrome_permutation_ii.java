public class Solution {
	public List<String> generatePalindromes(String s) {
		List<String> results = new ArrayList<String>();
		
		if(s == null || s.length() == 0)
			return results;
		
		Map<Character, Integer> d = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++) {
			if(d.containsKey(s.charAt(i)))
			   d.put(s.charAt(i), d.get(s.charAt(i))+1));
			else
			   d.put(s.charAt(i), 1);
		}
		
		String candidate = "";
		String single = "";
		boolean already = false;
		
		for(Character c : d.keySet()) {
			int num = d.get(c) / 2;
			for(int i = 0; i < num; i++)
				candidate += c;
			if(d.get(c) % 2 != 0) {
				if(already)
					return result;
				else {
					already = true;
					single += c;
				}
			}
		}
		
		if(candidate.length() == 0 && single.length() != 0) {
			results.add(single);
			return results;
		}
		
		recursion("", candidate, single, candidate.length(), results);
	}
	
	private void recursion(String left, String candidate, String single, int l, List<String> results) {
		if(left.length() == l) {
			String right = new StringBuffer(left).reverse().toString();
			results.add(left + single + right);
		}
		
		for(int i = 0; i < candidate.length(); i++) {
			if(i > 0 && candidate.charAt(i) == candidate.charAt(i-1))
				continue;
			recursion(left+candidate.charAt(i), candidate.substring(0, i)+candidate.substring(i+1), single, l, 
					  results);
		}
	}
}
