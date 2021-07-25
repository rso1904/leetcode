class Solution {
    public long maxPoints(int[][] points) {
        long res = 0;
        long[][] dp = new long[points.length][points[0].length];
        
        
        for(int i=0; i < points[0].length; i++) {
            dp[points.length-1][i] = points[points.length-1][i];
        }
        
        for(int i=points.length-2; i >= 0; i--) {
            long[] left = new long[points[0].length];
            long[] right = new long[points[0].length];
            
            left[0] = dp[i+1][0];
            for(int j=1; j < points[i].length; j++) {
                left[j] = Math.max(left[j-1], dp[i+1][j] + j);
            }
            
            right[points[i].length-1] = dp[i+1][points[i].length-1] - (points[i].length-1);
            for(int j=points[i].length-2; j >= 0 ; j--) {
                right[j] = Math.max(right[j+1], dp[i+1][j] - j);
            }
            
            for(int j=0; j < points[i].length; j++) {
                dp[i][j] = Math.max(left[j] - j , right[j] + j) + points[i][j];
            }
        }
        
        for(int i=0; i < points[0].length; i++) {
            res = Math.max(res, dp[0][i]);
        }
        
        return res;
    }
}