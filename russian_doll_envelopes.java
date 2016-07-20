public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Comparator<int[]> c = new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                return e1[0] - e2[0];
            }
        }
        Arrays.sort(envelopes, c);
        int max = 0;
        int[] res = new int[envelopes.length];
        for(int i = 0; i < res.length; i++) {
            res[i] = 1;
            for(int j = 0; j < i; j++) {
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    res[i] = Math.max(res[i], res[j]+1);
                }
            }
            max = Math.max(max, res[i]);
        }
        return max;
    }
}
