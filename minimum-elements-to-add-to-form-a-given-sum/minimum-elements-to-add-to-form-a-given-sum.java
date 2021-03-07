class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        double total = (double)goal / limit;
        double sum = 0;
        
        for(int i=0; i < nums.length; i++) {
            sum += (double)nums[i] / limit;
        }
                
        return (int)Math.ceil(Math.abs(total - sum));
    }
}