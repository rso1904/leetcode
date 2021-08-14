class Solution {
    public int countSpecialSubsequences(int[] nums) {
        long mod = (long)1e9 + 7;
        long[] dp = new long[3];
        
        for(int i=0; i < nums.length; i++) {
            if(nums[i] == 0) {
                dp[0] = ((dp[0] + dp[0]) % mod + 1) % mod;
            } else if(nums[i] == 1) {
                dp[1] = ((dp[1] + dp[1]) % mod + dp[0]) % mod;
            } else {
                dp[2] = ((dp[2] + dp[2]) % mod + dp[1]) % mod;
            }            
        }
        
        return (int)dp[2];
    }
}