public class Solution {
    public String rearrangeString(String str, int k) {
        int[] count = new int[26];
		int[] valid = new int[26];
		
		for(char c : str.toCharArray())
			count[c - 'a']++;
		
		StringBuffer buffer = new StringBuffer();
		
		for(int i = 0; i < str.length(); i++) {
			int curt = selectedValue(count, valid, i);
			if(curt == -1)
				return "";
			count[curt]--;
			valid[curt] = i + k;
			buffer.append((char)('a' + curt));
		}
		
		return buffer.toString();
    }
	
	private int selectedValue(int[] count, int[] valid, int i) {
		int select = Integer.MIN_VALUE;
		int val = -1;
		
		for(int j = 0; j < count.length; j++) {
			if(count[j] > 0 && i >= valid[j] && count[j] > select) {
				select = count[j];
				val = j;
			}
		}
		
		return val;
	}
}   
