class Solution {
    int[] dist;
    int res = 0;
    boolean[] seen;
    int[] mem;
    int mod = 1_000_000_000 + 7;
    
    public int countRestrictedPaths(int n, int[][] edges) {
        dist = new int[n+1];
        Map<Integer, List<int[]>> adjs = new HashMap<>();
        seen = new boolean[n+1];
        mem = new int[n+1];
        
        for(int i=0; i < edges.length; i++) {
            if(adjs.get(edges[i][0]) == null) {
                adjs.put(edges[i][0], new ArrayList<>());
            }
            
            if(adjs.get(edges[i][1]) == null) {
                adjs.put(edges[i][1], new ArrayList<>());
            }
            
            adjs.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
            adjs.get(edges[i][1]).add(new int[]{edges[i][0], edges[i][2]});
        }
        
        for (int i = 0; i < n; i++) 
            dist[i] = Integer.MAX_VALUE;
        
        dijkstra(adjs, n);
        return dfs(1, adjs, n);
    }
    
    private int dfs(int node, Map<Integer, List<int[]>> adjs, int endNode) {
        if(mem[node] != 0) {
            return mem[node];
        }
        
        if(node == endNode) {
            return 1;
        }
        
        int res = 0;
        
        seen[node] = true;
        
        for(int i=0; i < adjs.get(node).size(); i++) {
            int[] next = adjs.get(node).get(i);
            
            if(!seen[next[0]] && dist[node] > dist[next[0]]) {
                res = (res + dfs(next[0], adjs, endNode)) % mod;
            }
        }
        
        seen[node] = false;
        mem[node] = res % mod;
        
        return res;
    }
    
    private void dijkstra(Map<Integer, List<int[]>> adjs, int src){   
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] visited = new boolean[src+1];
        
        pq.offer(new int[]{src, 0});
        
  
        dist[src] = 0;
        
        while (!pq.isEmpty()) {
            int[] item = pq.poll();
            int current = item[0]; 
  
            visited[current] = true; 
  
            for (int i = 0; i < adjs.get(current).size(); i++) { 
                int[] next = adjs.get(current).get(i); 
      
                if (!visited[next[0]]) { 
                    if (dist[current] + next[1] < dist[next[0]]) {
                        dist[next[0]] = dist[current] + next[1];
                        pq.offer(new int[]{next[0], dist[next[0]]});
                    }
                } 
            }
        } 
    } 
}