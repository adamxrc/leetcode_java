public class Solution {
	public int maxSubArrayLen(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int len = 0;
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if(sum == k)
				len = i+1;
			if(map.containsKey(sum-k))
				len = Math.max(len, i-map.get(sum-k));
			if(map.containsKey(sum))
				map.put(sum, map.get(sum));
			else
				map.put(sum, i);
		}
		return len;
	}
}
