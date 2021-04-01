class Solution {
    public int reinitializePermutation(int n) {
        int[] nums = new int[n];
        boolean first = false;
        
        for(int i=0; i < n; i++) {
            nums[i] = i;
        }
        
        return search(nums, first);
    }
    
    private int search(int[] nums, boolean first) {
        if(first) {
            for(int i=1; i < nums.length; i++) {
                if(nums[i-1] > nums[i])
                    break;

                if(i == nums.length-1) {
                    return 0;
                }
            }
        } else {
            first = true;
        }
        
        int[] arr = new int[nums.length];
        
        for(int i=0; i < nums.length; i++) {
            if(i % 2 == 0) {
                arr[i] = nums[i / 2];
            } else {
                arr[i] = nums[nums.length / 2 + (i-1) / 2];
            }
        }
        
        return search(arr, first) + 1;
    }
}