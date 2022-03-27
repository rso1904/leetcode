class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {        
        int[][] dp = new int[k+1][piles.size()];
        int[][] prefix = new int[piles.size()][k+1];
        
        for(int i=0; i < piles.size(); i++) {
            for(int j=1; j <= piles.get(i).size() && j <= k; j++) {
                prefix[i][j] = prefix[i][j-1] + piles.get(i).get(j-1);    
            }
        }
        
        for(int i=0; i < piles.size(); i++) {
            for(int j=0; j <= k; j++) {
                for(int n=0; n <= j; n++) {
                    if(i == 0) {
                        dp[j - n][i] = prefix[i][n];
                    } else {
                        dp[j - n][i] = Math.max(dp[j-n][i], dp[j][i-1] + prefix[i][n]);
                    }
                }
            }
        }
        
        return dp[0][piles.size()-1];
    }
}