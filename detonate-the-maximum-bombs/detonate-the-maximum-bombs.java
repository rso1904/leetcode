class Solution {
    public int maximumDetonation(int[][] bombs) {
        double[][] dis = new double[100][100];
        Map<Integer, List<Integer>> map = new HashMap<>();
        int res = 1;
        
        for(int i=0; i < bombs.length; i++) {
            for(int j=0; j < bombs.length; j++) {
                if(i != j) {
                    long x = Math.abs(bombs[i][0] - bombs[j][0]);
                    long y = Math.abs(bombs[i][1] - bombs[j][1]);
                    dis[i][j] = Math.sqrt(x*x + y*y);
                    
                    if(dis[i][j] <= (double)bombs[i][2]) {
                        map.computeIfAbsent(i, a -> new ArrayList<>()).add(j);
                    }
                }
            }
        }
        
        for(int i=0; i < bombs.length; i++) {
            res = Math.max(res, bfs(i, map));
        }
        
        return res;
    }
    
    private int bfs(int cur, Map<Integer, List<Integer>> map) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[100];
        int res = 0;
        
        q.offer(cur);
        visited[cur] = true;
        
        while(!q.isEmpty()) {
            res++;
            int c = q.poll();
            
            List<Integer> adjs = map.get(c);
            
            if(adjs != null) {
                for(Integer adj : adjs) {
                    if(!visited[adj]) {
                        q.offer(adj);
                        visited[adj] = true;
                    }
                }
            }
        }
                
        return res;
    }
}