class Solution {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length / 2];
        
        for(int i=1; i < nums.length; i++) {
            int k = nums[i] - nums[0];
            
            if(k % 2 == 0 && k != 0) {
                Map<Integer, Integer> map = new HashMap<>();
                res = new int[nums.length / 2];        
                int index = 0;
                
                for(int j=0; j < nums.length; j++) {
                    map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                }
                
                for(int j=0; j < nums.length; j++) {
                    if(map.get(nums[j]) == 0) {
                        continue;
                    }
                    
                    if(map.get(nums[j] + k) == null || map.get(nums[j] + k) == 0) {
                        break;
                    }
                    
                    map.put(nums[j], map.get(nums[j]) - 1);
                    map.put(nums[j] + k, map.get(nums[j] + k) - 1);
                    
                    res[index++] = nums[j] + k / 2;
                }
                
                if(index == nums.length / 2) {
                    return res;
                }
            }
        }
        
        return res;
    }
}