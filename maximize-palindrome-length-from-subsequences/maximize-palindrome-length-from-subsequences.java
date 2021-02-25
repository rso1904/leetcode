class Solution {
    public int longestPalindrome(String word1, String word2) {
        String total = word1 + word2;
        int res = 0;
        int[][] dp = search(total);
        
        for(int i=0; i < word1.length(); i++) {
            for(int j=word2.length()-1; j >= 0; j--) {
                if(word1.charAt(i) == word2.charAt(j)) {
                    res = Math.max(res, dp[i][word1.length() + j]);
                    break;
                }
            }
        }
        
        return res;
    }
    
    private int[][] search(String s) {
        int[][] dp = new int[s.length()][s.length()];
    
        for(int i=s.length()-1; i >= 0; i--) {
            dp[i][i] = 1;
            
            for(int j=i+1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp;
    }
}