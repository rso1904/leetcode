class Solution {
    public int maxTrailingZeros(int[][] grid) {
        int[][][] v = new int[grid.length][grid[0].length][2];
        int[][][] h = new int[grid.length][grid[0].length][2];
        int res = 0;
        
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if(i == 0) {
                    v[i][j][0] = getTwo(grid[i][j]);
                    v[i][j][1] = getFive(grid[i][j]);
                } else {
                    v[i][j][0] = v[i-1][j][0] + getTwo(grid[i][j]);
                    v[i][j][1] = v[i-1][j][1] + getFive(grid[i][j]);
                }
            }
        }
        
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if(j == 0) {
                    h[i][j][0] = getTwo(grid[i][j]);
                    h[i][j][1] = getFive(grid[i][j]);
                } else {
                    h[i][j][0] = h[i][j-1][0] + getTwo(grid[i][j]);
                    h[i][j][1] = h[i][j-1][1] + getFive(grid[i][j]);
                }
            }
        }
        
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                int v1 = 0;
                int v11 = 0;
                if(i-1 >= 0) {
                    v1 = v[i-1][j][0];
                    v11 = v[i-1][j][1];
                }
                
                int v2 = 0;
                int v22 = 0;               
                if(i < grid.length-1) {
                    v2 = v[grid.length-1][j][0] - v[i][j][0];
                    v22 = v[grid.length-1][j][1] - v[i][j][1];
                }
                
                int h1 = 0;
                int h11 = 0;
                if(j-1 >= 0) {
                    h1 = h[i][j-1][0];
                    h11 = h[i][j-1][1];
                }
                
                int h2 = 0;
                int h22 = 0;
                if(j < grid[0].length-1) {
                    h2 = h[i][grid[0].length-1][0] - h[i][j][0];
                    h22 = h[i][grid[0].length-1][1] - h[i][j][1];
                }
                
                int cur1 = getTwo(grid[i][j]);
                int cur2 = getFive(grid[i][j]);
                int value = Math.min(v1 + h1 + cur1, v11 + h11 + cur2);
         
                res = Math.max(res, value);
                
                value = Math.min(v1 + h2 + cur1, v11 + h22+ cur2);
                res = Math.max(res, value);
                
                
                value = Math.min(v2 + h1 + cur1, v22 + h11 + cur2);
                res = Math.max(res, value);
                
                value = Math.min(v2 + h2 + cur1, v22 + h22 + cur2);
                res = Math.max(res, value);
            }
        }
        
        return res;
    }
    
    private int getTwo(int value) {
        int res = 0;
        
        while(value > 0) {
            if(value % 2 == 0) {
                res++;
                value /= 2;
            } else {
                break;
            }
        }
        
        return res;
    }
    
    private int getFive(int value) {
        int res = 0;
        
        while(value > 0) {
            if(value % 5 == 0) {
                res++;
                value /= 5;
            } else {
                break;
            }
        }
        
        return res;
    }
}