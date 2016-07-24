public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int fast = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while(fast < s.length()) {
            char ch = s.charAt(fast);
            
            if(slow == fast) {
                map.put(ch, fast);
                fast++;
                continue;
            }
            
            if(map.containsKey(ch)) {
                max = Math.max(max, fast-slow);
                int newSlow = map.get(ch);
                for(int i = slow; i <= newSlow; i++)
                    map.remove(s.charAt(i));
                slow = newSlow + 1;
            } else {
                map.put(ch, fast);
                fast++;
            }
        }
        return Math.max(max, fast-slow);
    }
}
