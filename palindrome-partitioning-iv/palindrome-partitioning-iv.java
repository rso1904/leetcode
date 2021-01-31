class Solution {
    public boolean checkPartitioning(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for(int i=0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        
        for(int i=1; i < s.length()-1; i++) {
            int left = i-1;
            int right = i+1;
            
            while(left >= 0 && right < s.length()) {
                if(s.charAt(left) == s.charAt(right)) {
                    dp[left][right] = dp[left+1][right-1];
                } else {
                    break;
                }
                
                left--;
                right++;
            }
            
            if(s.charAt(i) == s.charAt(i-1)) {
                dp[i-1][i] = true;
                left = i-2;
                right = i+1;
                
                while(left >= 0 && right < s.length()) {
                    if(s.charAt(left) == s.charAt(right)) {
                        dp[left][right] = dp[left+1][right-1];
                    } else {
                        break;
                    }
                    
                    left--;
                    right++;
                }
            }
            
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                left = i-1;
                right = i+2;
                
                while(left >= 0 && right < s.length()) {
                    if(s.charAt(left) == s.charAt(right)) {
                        dp[left][right] = dp[left+1][right-1];
                    } else {
                        break;
                    }
                    
                    left--;
                    right++;
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