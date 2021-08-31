class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        
        for(int i=nums.length-1; i >= k-1; i--) {
            int max = nums[i];
            int min = (i - k + 1) >= 0 ? nums[i - k + 1] : nums[0];
            res = Math.min(res, max - min);
        }
        
        return res;
    }
}