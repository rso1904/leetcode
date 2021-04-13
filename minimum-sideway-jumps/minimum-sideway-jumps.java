class Solution {
    int[][] mem;
    
    public int minSideJumps(int[] obstacles) {
        mem = new int[obstacles.length][4];
        return dfs(obstacles, -1, 2);
    }
    
    private int dfs(int[] obs, int cur, int lane) {
        int res = Integer.MAX_VALUE;
        
        if(cur != -1 && mem[cur][lane] != 0)
            return mem[cur][lane];
        
        if(cur == obs.length-1)
            return 0;
        
        if(obs[cur+1] != lane || obs[cur+1] == 0) {
            res = Math.min(res, dfs(obs, cur+1, lane));    
        } else if(obs[cur+1] == lane) {
            for(int i=1; i <=3; i++) {
                if(obs[cur+1] != i && obs[cur] != i) {
                    res = Math.min(res, dfs(obs, cur, i) + 1);
                }
            }
        }
        
        if(cur != -1)
            mem[cur][lane] = res;
        
        return res;
    }
}