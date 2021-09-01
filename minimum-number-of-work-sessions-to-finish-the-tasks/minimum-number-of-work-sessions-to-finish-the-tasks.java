class Solution {
    int[][][] dp;
    int visited = 0;
    int allVisited = 0;
    
    public int minSessions(int[] tasks, int sessionTime) {
        dp = new int[tasks.length+1][sessionTime+1][1<<16];
        
        for(int i=0; i < tasks.length; i++) {
            allVisited += 1 << i;
        }
        
        return dfs(tasks, sessionTime, 1, sessionTime);
    }
    
    private int dfs(int[] tasks, int cur, int total, int time) {
        if(visited == allVisited) {
            return total;
        }
        
        if(dp[total][cur][visited] != 0) {
            return dp[total][cur][visited];
        }
        
        int res = Integer.MAX_VALUE;
        
        for(int i=0; i < tasks.length; i++) {
            if((visited >> i & 1) != 1 && cur - tasks[i] >= 0) {
                visited += 1 << i;
                res = Math.min(res, dfs(tasks, cur - tasks[i], total, time));
                visited -= 1 << i;
            } else if((visited >> i & 1) != 1) {
                res = Math.min(res, dfs(tasks, time, total+1, time));
            }
        }
        
        dp[total][cur][visited] = res;
        
        return res;
    }
}