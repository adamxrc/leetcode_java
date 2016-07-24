public class Solution {
    public int maxProduct(int[] A) {
        int max = Integer.MIN_VALUE;
        int positive = 1;
        int negative = 1;
        for(int a: A) {
            int n1 = positive*a;
            int n2 = negative*a;
            int n3 = a;
            
            positive = Math.max(n1, n2);
            positive = Math.max(positive, n3);
            
            negative = Math.min(n1, n2);
            negative = Math.min(negative, n3);
            
            max = Math.max(max, positive);
        }
        return max;
    }
}
