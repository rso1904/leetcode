class Solution {
    public long gridGame(int[][] grid) {
        long[][] prefix = new long[2][grid[0].length];
        long max = Long.MAX_VALUE;
        
        for(int i=0; i < grid[0].length; i++) {
            if(i == 0) {
                prefix[0][i] = grid[0][i];
                prefix[1][i] = grid[1][i];
            } else {
                prefix[0][i] = prefix[0][i-1] + grid[0][i];
                prefix[1][i] = prefix[1][i-1] + grid[1][i];
            }
        }
        
        for(int i=0; i < grid[0].length; i++) {
            long first = prefix[0][grid[0].length-1] - prefix[0][i];
            long second = (i-1 >= 0 ? prefix[1][i-1] : 0);
            long value = Math.max(first, second);
                        
            if(value < max) {
                max = value;
            }
        }
        
        return max;
    }
}