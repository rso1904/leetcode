class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int[][] res = new int[isWater.length][isWater[0].length];
        boolean[][] visited = new boolean[isWater.length][isWater[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        for(int i=0; i < isWater.length; i++) {
            for(int j=0; j < isWater[i].length; j++) {
                if(isWater[i][j] == 1)
                    pq.offer(new int[]{0, i, j});
            }
        }
        
        while(!pq.isEmpty()) {
            int[] item = pq.poll();
            
            if(visited[item[1]][item[2]])
                continue;
            
            res[item[1]][item[2]] = item[0];
            visited[item[1]][item[2]] = true;
            
            for(int i=0; i < 4; i++) {
                int x = dir[i][0] + item[1];
                int y = dir[i][1] + item[2];
                
                if(x < isWater.length && x >=0 && y < isWater[0].length && y >= 0 && !visited[x][y]) {
                    pq.offer(new int[]{item[0]+1, x, y});
                }
            }
        }
        
        return res;
    }
}