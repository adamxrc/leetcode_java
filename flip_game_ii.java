public class Solution {
    public boolean firstPlayWinning(String s) {
        return canWin(s.toCharArray());
    }
    
    private boolean canWin(char[] chs) {
        for(int i = 0; i < chs.length-1; i++) {
            if(chs[i] == chs[i+1] && chs[i] == '+') {
                chs[i] = '-';
                chs[i+1] = '-';
                boolean win = !canWin(chs);
                chs[i] = '+';
                chs[i+1] = '+';
                if(win)
                    return true;
            }
        }
        return false;
    }
}
