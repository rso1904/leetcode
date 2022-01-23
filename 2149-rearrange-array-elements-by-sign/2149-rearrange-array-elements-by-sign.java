class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] p = new int[nums.length / 2];
        int[] n = new int[nums.length / 2];
        int pi = 0;
        int ni = 0;
        
        for(int i=0; i < nums.length; i++) {
            if(nums[i] > 0) {
                p[pi++] = nums[i];
            } else {
                n[ni++] = nums[i];
            }
        }
        
        pi = 0;
        ni = 0;
        
        for(int i=0; i < nums.length; i++) {
            if(i % 2 == 0) {
                nums[i] = p[pi++];
            } else {
                nums[i] = n[ni++];
            }
        }
        
        return nums;
    }
}