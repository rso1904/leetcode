class Solution {
    public int maximumDifference(int[] nums) {
        int start = nums[0];
        int ans = -1;
        
        for(int i=1; i < nums.length; i++) {
            if(start < nums[i]) {
                ans = Math.max(ans, nums[i] - start);
            } else {
                start = nums[i];
            }
        }
        
        return ans;
    }
}