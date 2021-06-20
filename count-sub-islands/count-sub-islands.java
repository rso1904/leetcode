class Solution {
    boolean[][] visited;
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        visited = new boolean[grid1.length][grid1[0].length];
        int res = 0;
        
        for(int i=0; i < grid1.length; i++) {
            for(int j=0; j < grid1[i].length; j++) {
                if(!visited[i][j] && grid1[i][j] == 1 && grid2[i][j] == 1) {
                    if(!bfs(grid1, grid2, i, j)) {
                        res += 1;
                    }
                }
            }
        }
        
        return res;
    }
    
    private boolean bfs(int[][] grid1, int[][] grid2, int row, int col) {
        boolean check = false;
        int[][] dir = {{1,0}, {-1, 0}, {0, 1}, {0,-1}};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
                        
            for(int i=0; i < 4; i++) {
                int nextR = cur[0] + dir[i][0];
                int nextC = cur[1] + dir[i][1];
                
                if(nextR >= 0 && nextR < grid2.length && nextC >= 0 && nextC < grid2[0].length && !visited[nextR][nextC] && grid2[nextR][nextC] == 1) {
                    if(grid1[nextR][nextC] == 0) {
                        check = true;
                    }
                    
                    visited[nextR][nextC] = true;
                    q.offer(new int[]{nextR, nextC});
                }
            }
        }
        
        return check;
    }
}