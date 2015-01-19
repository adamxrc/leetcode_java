public class Solution {
	
	public int jump(int[] A) {
		int jump = 0;
		int lastMax = 0;
		int curMax = 0;
		
		for(int i = 0; i < A.length; i++) {
			if(lastMax < i) {
				jump++;
				lastMax = curMax;
			}
			curMax = Math.max(curMax, A[i]+i);
		}
		
		return jump;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int A[] = {2, 3, 1, 1, 4};
		System.out.println(s.jump(A));
	}

}