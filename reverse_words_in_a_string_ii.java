public class Solution {
  public String reverse(String input) {
    char[] chars = input.toCharArray();
    int len = chars.length;
    reverse(chars, 0, len-1);
    int wordStart = -1;
    int wordEnd= -1;
    for(int i = 0; i < len; i++) {
      if(chars[i] == ' ' || i == len-1) {
        if(wordStart >= 0 && wordEnd >= 0) {
          reverse(chars, wordStart, wordEnd);
          wordStart = -1;
          wordEnd = -1;
        }
      } else {
        if(wordStart == -1)
          wordStart = i;
        wordEnd = i;
      }
    }
    
    return new String(chars);
  }
  
  private void reverse(char[] chars, int start, int end) {
    while(start < end) {
      char temp = chars[start];
      chars[start] = chars[end];
      chars[end] = temp;
      start++;
      end--;
    }
  }
}
