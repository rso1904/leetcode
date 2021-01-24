class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int[] row = new int[matrix[0].length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        
        for(int i=0; i < matrix.length; i++) {
            row = new int[matrix[0].length];
            
            for(int j=0; j < matrix[i].length; j++) {
                if(i == 0) {
                    dp[i][j] = j > 0 ? dp[i][j-1] ^ matrix[i][j] : matrix[i][j];
                } else {
                    row[j] = j > 0 ? row[j-1] ^ matrix[i][j] : matrix[i][j];
                    dp[i][j] = dp[i-1][j] ^ row[j];
                }
         //       System.out.println(i + " : " + j + " : " + dp[i][j]);
                pq.offer(dp[i][j]);
                minpq.offer(dp[i][j]);
            }
        }
        int ans = 0;
        int len = (matrix.length * matrix[0].length - k + 1);
        if(k > len) {
            for(int i=0; i < k; i++) {
                ans = pq.poll();  
            }
        } else {
            for(int i=0; i < len; i++) {
                ans = minpq.poll();  
            }
        }
​
        return ans;
    }
}
