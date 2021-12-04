class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;
        int res = Integer.MAX_VALUE;
        
        for(int i=0; i < nums.length; i++) {
            if(nums[i] <= min) {
                min = nums[i];
                minIndex = i;
            }
            
            if(nums[i] >= max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        
        if(Math.max(minIndex+1, maxIndex+1) < res) {
            res = Math.max(minIndex+1, maxIndex+1);
        }
        
        if(Math.max(nums.length - minIndex, nums.length - maxIndex) < res) {
            res = Math.max(nums.length - minIndex, nums.length - maxIndex);
        }
        
        if(minIndex < maxIndex) {
            if((minIndex+1 + nums.length - maxIndex) < res) {
                res = (minIndex+1 + nums.length - maxIndex);
            }
        } else {
            if((maxIndex+1 + nums.length - minIndex) < res) {
                res = (maxIndex+1 + nums.length - minIndex);
            }
        }
        
        return res;
    }
}