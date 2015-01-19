public class Solution {
	
	public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int total = m + n;
        if(total % 2 != 0) {
            return findKth(A, m, B, n, total/2+1);
        } else {
            return (findKth(A, m, B, n, total/2)+findKth(A, m, B, n, total/2+1))/2;
        }
    }
    
    private double findKth(int A[], int m, int B[], int n, int k) {
        if(m > n) 
            return findKth(B, n, A, m, k);
        if(m == 0) 
            return B[k-1];
        if(k == 1) 
            return Math.min(A[0], B[0]);
        int pa = Math.min(k/2, m), pb = k - pa;
        if(A[pa-1] < B[pb-1]) {
            int[] C = new int[m-pa];
            System.arraycopy(A, pa, C, 0, m-pa);
            return findKth(C, m-pa, B, n, k-pa);
        } else if(A[pa-1] > B[pb-1]) {
            int[] C = new int[n-pb];
            System.arraycopy(B, pb, C, 0, n-pb);
            return findKth(A, m, C, n-pb, k-pb);
        } else {
            return A[pa-1];
        }
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int A[] = {1, 1, 1, 2, 2, 3};
		System.out.println(s.jump(A));
	}

}