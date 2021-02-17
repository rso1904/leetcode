class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 1_000_000_000;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            
            for(int i=0; i < nums.length; i++) {
                count += (nums[i] - 1) / mid;    
            }
            
            if(count > maxOperations) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}