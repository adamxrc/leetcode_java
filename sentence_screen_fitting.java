public class Solution {
	public int wordsTyping(String[] sentence, int rows, int cols) {
		int i = 0, j = 0, k = 0, times = 0;
		
		while(i < rows && j < cols) {
			if(sentence[k].length() > cols)
				break;
			
			int remain = cols - j;
			if(remain == sentence[k].length() + 1 || remain == sentence[k].length()) {
				i++;
				j = 0;
				k++;
			} else if(remain < sentence[k].length()) {
				i++;
				j = 0;
			} else {
				j = j + sentence[k].length() + 1;
				k++;
			}
			
			if(k == sentence.length) {
				k = 0;
				times++;
			}
		}
		
		return times;
	}
}
