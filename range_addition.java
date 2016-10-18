/*
 * 解法：这题与算法无关，是个数学题。思想是把所有需要相加的值存在第一个数，然后把这个范围的最后一位的下一位减去这个inc, 
 * 这样我所以这个范围在求最终值的时候，都可以加上这个inc，而后面的数就不会加上inc。
 */
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for(int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int inc = updates[i][2];
            result[start] += inc;
            if(end < length-1)
                result[end+1] -= inc;
        }
        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += result[i];
            result[i] = sum;
        }
        return result;
    }
}
