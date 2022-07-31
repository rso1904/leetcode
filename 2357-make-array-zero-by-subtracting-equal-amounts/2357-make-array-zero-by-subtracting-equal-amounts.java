class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        
        int res = 0;
        int prev = 0;
        int target = nums[nums.length-1];
        
        for(int i=0; i < nums.length; i++) {
            if(nums[i] != 0 && nums[i] > prev) {
                res++;
            }
      //      System.out.println(prev + " : " + nums[i] + " : "+ res);
            prev = nums[i];
        }
        
        return res;
    }
}