class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> index = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        
        for(int i=0; i < nums.length; i++) {
            if(nums[i] == key) {
                index.add(i);
            }
        }
        
        for(int i=0; i < nums.length; i++) {
            for(Integer ind : index) {
                if(Math.abs(ind - i) <= k) {
                    res.add(i);
                    break;
                }
            }
        }
        
        return res;
    }
}