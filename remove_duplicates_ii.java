public class Solution {
	
	public int removeDuplicates(int A[]) {
		int n = A.length;
		if(n <= 2) return n;
		
		int index = 2;
		for(int i = 2; i < n; i++) {
			if(A[index-2] != A[i])
				A[index++] = A[i];
		}
		
		return index;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int A[] = {1, 1, 1, 2, 2, 3};
		System.out.println(s.jump(A));
	}

}