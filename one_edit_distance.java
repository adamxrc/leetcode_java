public class Solution {
  public boolean isOneEditDistance(String s, String t) {
    return check(s, t, 0, 0, 0);
  }
  
  private boolean check(String s, String t, int i, int j, int distance) {
    while(i >= 0 && i < s.length() && j >= 0 && j < t.length()) {
      if(s.charAt(i) != t.charAt(j)) {
        distance++;
        if(distance > 1)
          return false;
        return check(s, t, i+1, j, distance) || check(s, t, i, j+1, distance) || check(s, t, i+1, j+1, distance);
      } else
        return check(s, t, i+1, j+1, distance);
    }
    
    if(distance == 1)
      return i == s.length() && j == t.length();
    else
      return Math.abs(s.length()-t.length()) == 1;
  }
}
