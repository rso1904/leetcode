class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        
        for(int i=1; i < nums.length-1; i++) {
            if(nums[0] < nums[i] && nums[i] < nums[nums.length-1]) {
                res++;
            }
        }
        
        return res;
    }
}