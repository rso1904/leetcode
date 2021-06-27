class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int size = Math.min(rowLen, colLen) / 2;
        int start = 0;
        int rowMax = grid.length;
        int colMax = grid[0].length;
        int[][] res = new int[grid.length][grid[0].length];
        
        while(size > 0) {
            int sz = rowMax * 2 + colMax * 2 - 4;
            int r = start;
            int c = start;
            int change = 0;
         //   System.out.println(start + " : " + sz);
            for(int i=0; i < sz; i++) {
                int mul = k / sz + 1;
                int nextPos = (sz * mul + (i - k)) % sz + 1;
                int[] next = get(nextPos, start, rowMax, colMax);
                
         //       System.out.println(nextPos + " : " + next[0] + " : " + next[1] + " : " + r + " : " + c + " : " + change);
                
                if(change == 0) {
                    res[next[0]][next[1]] = grid[r][c++];
                    
                    if(c == start + colMax) {
                        change++;
                        c--;
                        r++;
                    }
                } else if(change == 1) {
                    res[next[0]][next[1]] = grid[r++][c];
                    
                    if(r == start + rowMax) {
                        change++;
                        r--;
                        c--;
                        
                        if(c == start) {
                            change++;
                        }
                    }
                } else if(change == 2) {
                    res[next[0]][next[1]] = grid[r][c--];
                    
                    if(c == start) {
                        change++;
                    }
                } else {
                    res[next[0]][next[1]] = grid[r--][c];
                    
                    if(r == start) {
                        change++;
                    }
                }
            }
            
            rowMax -= 2;
            colMax -= 2;
            size--;
            start++;
        }
        
        return res;
    }
    
    private int[] get(int nextPos, int start, int rL, int cL) {
//        System.out.println(nextPos + " : " + (rL * 2 + cL - 2 - 1) + " : " + rL + " : " + cL);
        if(nextPos >= cL * 2 + rL - 2) {
            return new int[]{start + rL - (nextPos - (cL * 2 + rL - 2)) - 1, start};
        } else if(nextPos >= rL + cL - 1) {
            return new int[]{start + rL-1, start + cL - (nextPos - (rL + cL - 1)) - 1};
        } else if(nextPos >= cL) {
            return new int[]{start + (nextPos - cL), start + cL-1};
        } else {
            return new int[]{start, start + (nextPos) - 1};
        }
    }
}