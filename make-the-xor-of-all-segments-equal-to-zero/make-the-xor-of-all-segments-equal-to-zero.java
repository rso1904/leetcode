class Solution {
    public int minChanges(int[] nums, int k) {
        int[][] dp = new int[k+1][1025];
        int[][] freq = new int[k][1025];
        
        for(int i=0; i < nums.length; i++) {
            freq[i%k][nums[i]]++;
        }
        
        for(int i=0; i < k+1; i++) {
            for(int j=0; j < 1025; j++) {
                dp[i][j] = 2048;
            }
        }
        
        dp[0][0] = 0;
        int prevMin = 0;
        
        for(int i=0; i < k; i++) {
            int sizeOfPos = (int)Math.ceil((nums.length - i) * 1.0 / k);
            int curMin = Integer.MAX_VALUE;
            
            for(int j=0; j < 1025; j++) {
                for(int z=i; z < nums.length; z += k) {
                    if((j ^ nums[z]) < 1025) {
                        dp[i+1][j ^ nums[z]] = Math.min(dp[i+1][j ^ nums[z]], dp[i][j] + sizeOfPos - freq[i][nums[z]]);
                    }
                }
                
                dp[i+1][j] = Math.min(dp[i+1][j], prevMin + sizeOfPos);
                curMin = Math.min(curMin, dp[i+1][j]);
            }
            prevMin = curMin;
        }
        
        return dp[k][0];
    }
}