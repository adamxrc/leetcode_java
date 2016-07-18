public class Solution {
  
  List<String> res = new ArrayList<String>();
  
  public List<String> addOperators(String num, int target) {
    helper(num, target, "", 0, 0);
    return res;
  }
  
  private void helper(String num, int target, String tmp, int currRes, int prevNum) {
    if(currRes == target && num.length() == 0) {
      String exp = new String(tmp);
      res.add(exp);
      return;
    }
    
    for(int i = 1; i <= num.length(); i++) {
      String currStr = num.substring(0, i);
      if(currStr.length() > 1 && currStr.charAt(0) == '0') {
        return;
      }
      long currNum = Long.parseLong(currStr);
      String next = num.substring(i);
      if(tmp.length() != 0) {
        helper(next, target, tmp+"*"+currNum, (currRes-prevNum)+prevNum*currNum, prevNum*currNum);
        helper(next, target, tmp+"+"+currNum, currRes+currNum, currNum);
        helper(next, target, tmp+"-"+currNum, currRes-currNum, -currNum);
      } else {
        helper(next, target, currStr, currNum, currNum);
      }
    }
  }
  
}
