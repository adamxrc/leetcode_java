public class Solution {
	Map<Character, String> map;
	Set<String> set;
	boolean res;
	
	public boolean wordPatternMatch(String pattern, String str) {
		map = new HashMap<Character, String>();
		set = new HashSet<String>();
		res = false;
		helper(pattern, str, 0, 0);
		return res;
	}
	
	private void helper(String pattern, String str, int i, int j) {
		if(i == pattern.length() && j == str.length()) {
			res = true;
			return;
		}
		
		if(i >= pattern.length() || j >= str.length())
			return;
		
		char c = pattern.charAt(i);
		for(int cut = j+1; cut <= str.length(); cut++) {
			String substr = str.substring(j, cut);
			if(!set.contains(substr) && !map.containsKey(c)) {
				set.add(substr);
				map.put(c, substr);
				helper(pattern, str, i+1, cut);
				set.remove(substr);
				map.remove(c);
			} else if(map.containsKey(c) && map.get(c).equals(substr))
				helper(pattern, str, i+1, cut);
		}
	}
}
