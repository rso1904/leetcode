class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] zero = new int[nums.length];
        int[] one = new int[nums.length];
        int max = 0;
        
        for(int i=0; i < nums.length; i++) {
            zero[i] = i == 0 ? (nums[i] == 0 ? 1 : 0) : zero[i-1] + (nums[i] == 0 ? 1 : 0);
            one[nums.length - 1 - i] = i == 0 ? (nums[nums.length - 1 - i] == 1 ? 1 : 0) : one[nums.length - i] + (nums[nums.length - 1 - i] == 1 ? 1 : 0);
        }
        
        for(int i=0; i <= nums.length; i++) {
            int value = 0;
            
            if(i == 0) {
                value = one[i];
            } else if(i == nums.length) {
                value = zero[i-1];
            } else {
                value = zero[i-1] + one[i];
            }
            
            if(value > max) {
                res.clear();
                res.add(i);
                max = value;
            } else if(value == max) {
                res.add(i);
            }
        }
        
        return res;
    }
}