class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;
        
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
        if(maxIndex < minIndex) {
            int temp = maxIndex;
            maxIndex = minIndex;
            minIndex = temp;
        }
        
        return Math.min(maxIndex+1, Math.min(nums.length - minIndex, minIndex+1 + nums.length - maxIndex));
    }
}