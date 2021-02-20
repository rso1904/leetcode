class Solution {
    public boolean check(int[] nums) {
        if(nums.length == 1)
            return true;
        
        for(int i=1; i < nums.length; i++) {
            if(nums[i-1] > nums[i]) {
                break;
            }
                
            if(i == nums.length-1)
                return true;
        }
        
        for(int i=1; i < nums.length; i++) {
            int[] arr = new int[nums.length];
            
            for(int j=0; j < nums.length; j++) {
                arr[(j+i) % nums.length] = nums[j];     
            }
            
            for(int j=1; j < nums.length; j++) {
                if(arr[j-1] > arr[j]) {
                    break;
                }
                
                if(j == nums.length-1)
                    return true;
            }
        }
        
        return false;
    }
}