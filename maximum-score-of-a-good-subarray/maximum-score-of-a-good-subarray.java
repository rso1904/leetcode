class Solution {
    public int maximumScore(int[] nums, int k) {
        int res = 0;
        int min = nums[k];
        int left = k-1;
        int right = k+1;
        res = Math.max(res, min);
        
        while(left >= 0 && right < nums.length) {
            if(nums[left] > nums[right]) {
                min = Math.min(min, nums[left]);
                res = Math.max(res, min * ((right - 1) - left + 1));
                left--;
            } else {
                min = Math.min(min, nums[right]);
                res = Math.max(res, min * (right - (left + 1) + 1));
                right++;
            }
        }
        
        while(left >= 0) {
            min = Math.min(min, nums[left]);
            res = Math.max(res, min * ((right - 1) - left + 1));
            left--;
        }
        

        while(right < nums.length) {
            min = Math.min(min, nums[right]);
            res = Math.max(res, min * (right - (left + 1) + 1));
            right++;
        }
        
        return res;
    }
}