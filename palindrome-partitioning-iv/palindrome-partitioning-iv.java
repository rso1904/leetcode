class Solution {
    public boolean checkPartitioning(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for(int i=s.length()-1; i >= 0; i--) {
            for(int j=i; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = i+1 <= j-1 ? dp[i+1][j-1] : true;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        
        for(int i=0; i < s.length(); i++) {
            for(int j=i+1; j < s.length(); j++) {
                if(j+1 >= s.length())
                        break;
                    
                if(dp[0][i] && dp[i+1][j] && dp[j+1][s.length()-1]) {
                    return true;
                }
            }
        }
        
        return false;
    }
}