class Solution {
    public int largestCombination(int[] candidates) {
        int[] count = new int[32];
        int res = 0;
        
        for(int i=0; i < candidates.length; i++) {
            for(int j=0; j < 32; j++) {
                if((candidates[i] >> j & 1) == 1) {
                    count[j]++;
                }
            }
        }
        
        for(int i=0; i < 32; i++) {
            res = Math.max(res, count[i]);    
        }
        
        return res;
    }
}