class Solution {
    int len = 0;
    int res = Integer.MAX_VALUE;
    
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int[][] dp = new int[toppingCosts.length][3];
        len = toppingCosts.length;
        
        
        for(int j=0; j < toppingCosts.length; j++) {
            for(int k=0; k <= 2; k++) {
                dp[j][k] = toppingCosts[j] * k;
            }
        }
        
        for(int i=0; i < baseCosts.length; i++) {
            dfs(dp, baseCosts, target, 0, i, 0);
        }
        
        return res;
    }
    
    private void dfs(int[][] dp, int[] baseCosts, int target, int total, int i, int j) {
        if(j == len) {
            if(Math.abs(target - res) > Math.abs(target - (total + baseCosts[i]))) {
                res = total + baseCosts[i];
            } else if(Math.abs(target - res) == Math.abs(target - (total + + baseCosts[i]))) {
                if((total + baseCosts[i]) < res) {
                    res = total + baseCosts[i];
                }
            }
            
            return;
        }
        
        for(int k=0; k <= 2; k++)
            dfs(dp, baseCosts, target, total + dp[j][k], i, j+1);
    }
}