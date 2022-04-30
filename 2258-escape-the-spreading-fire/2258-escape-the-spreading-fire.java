class Solution {
    Queue<int[]> pq = new LinkedList<>();
    
    public int maximumMinutes(int[][] grid) {
        int time = 1;
        int[][] fire = new int[grid.length][grid[0].length];
        int[][] mat = new int[grid.length][];
        int res = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    pq.offer(new int[]{i, j, 0});
                }
            }
        }
        
        for(int i = 0; i < grid.length; i++)
            mat[i] = grid[i].clone();
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            check(cur[0], cur[1], mat, fire, cur[2]+1);
        }
        
        for(int i=0; i < fire.length; i++) {
            for(int j=0; j < fire[i].length; j++) {
                if(fire[i][j] == 0) {
                    fire[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        /*
        for(int i=0; i < fire.length; i++) {
            for(int j=0; j < fire[i].length; j++) {
                System.out.print(fire[i][j] + " ");
            }
            System.out.println();
        } */
        
        pq.offer(new int[]{0, 0, 0, fire[0][0] - 1});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            visited[cur[0]][cur[1]] = true;
            
       //     System.out.println(cur[0] + " : " + cur[1] + " : " + cur[2] + " : " + cur[3] + " : " + fire[cur[0]][cur[1]]);
            
            if(cur[2] > fire[cur[0]][cur[1]]) {
                continue;
            }
            
            if(cur[2] == fire[cur[0]][cur[1]]) {
                if(cur[0] == grid.length-1 && cur[1] == grid[0].length-1) {
                    res = Math.max(res, Math.max(0, cur[3]));
                }
                continue;
            }
            
            if(cur[0] == grid.length-1 && cur[1] == grid[0].length-1) {
            //    System.out.println("hi" + " : " + cur[3]);
                res = Math.max(res, Math.max(0, cur[3]));
                continue;
            }

            
            
            for(int i=0; i < dir.length; i++) {
                int nextX = cur[0] + dir[i][0];
                int nextY = cur[1] + dir[i][1];
               
                if(nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
               //     System.out.println(nextX + " : " + nextY + " : " + (fire[nextX][nextY] - cur[2] - 1));
                    int value = fire[nextX][nextY] - cur[2] - 1;
                    
                    if(fire[cur[0]][cur[1]] < fire[nextX][nextY]) {
                        value--;
                    }
                    
                    pq.offer(new int[]{nextX, nextY, cur[2]+1, Math.min(value, cur[3])});
                }
            }
        }
        
        return res == Integer.MIN_VALUE ? -1 : res >= 2_000_000 ? 1_000_000_000 : res;
    }
    
    private void check(int row, int col, int[][] mat, int[][] fire, int time) {
        if(row-1 >= 0 && mat[row-1][col] == 0) {
            pq.offer(new int[]{row-1, col, time});
            mat[row-1][col] = 1;
            fire[row-1][col] = time;
        }
        
        if(row+1 < mat.length && mat[row+1][col] == 0) {
            pq.offer(new int[]{row+1, col, time});
            mat[row+1][col] = 1;
            fire[row+1][col] = time;
        }
        
        if(col - 1 >= 0 && mat[row][col-1] == 0) {
            pq.offer(new int[]{row, col-1, time});
            mat[row][col-1] = 1;
            fire[row][col-1] = time;
        }
        
        if(col + 1 < mat[0].length && mat[row][col+1] == 0) {
            pq.offer(new int[]{row, col+1, time});
            mat[row][col+1] = 1;
            fire[row][col+1] = time;
        }
    }
}