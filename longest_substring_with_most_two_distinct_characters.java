public class Solution {

  public int lengthOfLongestSubstringTwoDistinct(String s) {
    int start = 0;
    int maxLen = 0;
    Map<Character,Integer> map = new HashMap<Character,Integer>();
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(map.containsKey(c)) 
        map.put(c, map.get(c)+1);
      else {
        map.put(c, 1);
        while(map.size() > 2) {
          char startChar = s.charAt(start++);
          int count = map.get(startChar);
          if(count > 1) 
            map.put(startChar, count - 1);
          else
            map.remove(startChar);
        }
      }
      maxLen = Math.max(maxLen, i-start+1);
    }
    return maxLen;
  }

}
