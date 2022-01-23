class Solution {
    public List<Integer> findLonely(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        
        if(nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        
        for(int i=0; i < nums.length; i++) {
            if(i == 0) {
                if(nums[i+1] != nums[i] && nums[i] + 1 != nums[i+1]) {
                    res.add(nums[i]);
                }
            } else if(i == nums.length-1) {
                if(nums[i-1] != nums[i] && nums[i-1] + 1 != nums[i]) {
                    res.add(nums[i]);
                }
            } else {
                if(nums[i+1] != nums[i] && nums[i] + 1 != nums[i+1] && nums[i-1] != nums[i] && nums[i-1] + 1 != nums[i]) {
                    res.add(nums[i]);
                }
            }    
        }
        
        return res;
    }
}