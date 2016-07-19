public class Solution {
    public int[] maxSlidingWindow(int[] A, int w) {
        if(A == null || w <= 0 || A.length - w < 0)
            return new int[0];
        int[] B = new int[A.length-w+1];
        LinkedList<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < A.length; i++) {
            int data = A[i];
            while(!q.isEmpty() && q.getLast() < data) {
                q.removeLast();
            }
            q.add(data);
            if(i < w-1)
                continue;
            B[i-w+1] = q.get(0);
            if(A[i-w+1] == B[i-w+1]) {
                q.removeFirst();
            }
        }
        return B;
    }
}
