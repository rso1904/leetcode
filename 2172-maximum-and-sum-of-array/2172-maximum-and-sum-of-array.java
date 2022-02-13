class Solution {
    int[] mem;
    int[] size;
    
    public int maximumANDSum(int[] nums, int numSlots) {
        int mask = (int)Math.pow(3, numSlots) - 1;
        mem = new int[mask+1];
        size = new int[numSlots+1];
        
        return search(nums, 0, mask, numSlots);
    }
    
    private int search(int[] nums, int cur, int mask, int numSlots) {
        if(cur >= nums.length) {
            return 0;
        }
        if(mem[mask] > 0) {
            return mem[mask];
        }
        
        int res = 0;
        
        for(int i=1; i <= numSlots; i++) {
            if(size[i] < 2) {
                size[i]++;
                
                res = Math.max(res, search(nums, cur+1, mask - (int)Math.pow(3, i-1), numSlots) + (i & nums[cur]));
                size[i]--;
            } 
        }
        
        mem[mask] = res;
        return res;
    }
}