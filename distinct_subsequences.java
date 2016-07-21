public class Solution {
    public int numDistinct(String S, String T) {
        if(T.length() == 0)
            return 1;
        if(S.length() == 0)
            return 0;
        
        int[][] cache = new int[S.length()][T.length()];
        for(int i = 0; i < S.length(); i++)
            for(int j = 0; j <= i && j < T.length(); j++) {
            if(S.charAt(i) != T.charAt(j)) {
                if(i > j)
                    cache[i][j] = cache[i-1][j];
                else
                    cache[i][j] = 0;
            } else {
                if(i > j) {
                    if(j == 0)
                        cache[i][j] = cache[i-1][j] + 1;
                    else
                        cache[i][j] = cache[i-1][j] + cache[i-1][j-1];
                } else {
                    if(i == 0)
                        cache[i][j] = 1;
                    else
                        cache[i][j] = cache[i-1][j-1];
                }
            } 
        }
        
        return cache[S.length()-1][T.length()-1];
    }
}
