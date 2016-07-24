public class Solution {
    public String longestPalindrome(String s) {
        String sub = "";
        for(int i = 0; i < s.length(); i++) {
            int j;
            
            for(j = 0; i-j>=0 && i+j<s.length(); j++) {
                if(s.charAt(i-j) == s.charAt(i+j)) {
                    if(j*2+1 > sub.length())
                        sub = s.substring(i-j, i+j+1);
                } else
                    break;
            }
            
            for(j = 0; i-j>=0 && i+j+1<s.length(); j++) {
                if(s.charAt(i-j) == s.charAt(i+j+1)) {
                    if((j+1)*2 > sub.length())
                        sub = s.substring(i-j, i+j+2);
                } else
                    break;
            }
        }
        return sub;
    }
}
