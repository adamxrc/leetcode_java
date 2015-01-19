public class Solution {
	
	public int removeDuplicates(int A[]) {
		int n = A.length;
		if(n == 0) return 0;
		
		int index = 0;
		for(int i = 1; i < n; i++) {
			if(A[index] != A[i])
				A[++index] = A[i];
		}
		
		return index + 1;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int A[] = {2, 3, 1, 1, 4};
		System.out.println(s.jump(A));
	}

}