public class Solution {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		int[] f = new int[nums.length];
		if(a > 0) {
			for(int i = 0, j = nums.length-1, k = f.length-1; k >= 0; k--) {
				int fi = nums[i] * nums[i] * a + nums[i] * b + c;
				int fj = nums[j] * nums[j] * a + nums[j] * b + c;
				if(fi >= fj) {
					f[k] = fi;
					i++;
				} else {
					f[k] = fj;
					j--;
				}
			}
		} else if(a < 0) {
			for(int i = 0, j = nums.length-1, k = 0; k < f.length; k++) {
				int fi = nums[i] * nums[i] * a + nums[i] * b + c;
				int fj = nums[j] * nums[j] * a + nums[j] * b + c;
				if(fi <= fj) {
					f[k] = fi;
					i++;
				} else {
					f[k] = fj;
					j--;
				}
			}
		} else if(b > 0) {
			for(int i = 0; i < f.length; i++)
				f[i] = nums[i] * b + c;
		} else if(b < 0) {
			for(int i = 0, j = f.length-1; i < f.length; i++, j--)
				f[j] = nums[i] * b + c;
		} else {
			for(int i = 0; i < f.length; i++)
				f[i] = c;
		}
		return f;
	}
}
