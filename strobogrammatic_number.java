public class Solution {
    public boolean isStrobogrammatic(String num) {
        char[] chs = num.toCharArray();
        int i = 0, j = chs.length - 1;
        while(i <= j) {
            if((chs[i] == '0' && chs[j] == '0') || 
               (chs[i] == '1' && chs[j] == '1') || 
               (chs[i] == '8' && chs[j] == '8') || 
               (chs[i] == '6' && chs[j] == '9') || 
               (chs[i] == '9' && chs[j] == '6')) {
                i++;
                j--;
            } else
                return false;
        }
        return true;
    }
}
