public class Solution {
    public int kthLargestElement(int k, int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(k <= 0)
            return 0;
        return helper(nums, 0, nums.length-1, k);
    }
    
    private int helper(int[] nums, int l, int r, int k) {
        if(l == r)
            return nums[l];
        int position = partition(nums, l, r);
        if(position+1 == k)
            return nums[position];
        else if(position+1 < k)
            return helper(nums, position+1, r, k);
        else
            return helper(nums, l, position-1, k);
    }
    
    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while(l < r) {
            while(l < r && nums[r] >= pivot)
                r--;
            nums[l] = nums[r];
            while(l < r && nums[l] <= pivot)
                l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }
}
