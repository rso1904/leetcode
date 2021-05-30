class Solution {
    public int stoneGameVIII(int[] stones) {
        int[] prefix = new int[stones.length];
        int[] dp = new int[stones.length];
        
        for(int i=0; i < stones.length; i++) {
            prefix[i] = i == 0 ? stones[i] : prefix[i-1] + stones[i];
        }
        
        dp[stones.length-2] = prefix[stones.length-1];
        
        for(int i=stones.length-3; i >= 0; i--) {
            dp[i] = Math.max(dp[i+1], prefix[i+1] - dp[i+1]);
        }
        
        return dp[0];
    }
}