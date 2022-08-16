class Solution {
    public int longestCycle(int[] edges) {
        boolean[] visited = new boolean[edges.length];
        Queue<Integer> q = new LinkedList<>();
        int res = -1;
        
        for(int i=0; i < edges.length; i++) {
            if(!visited[i]) {
                q.offer(i);   
                res = Math.max(res, bfs(q, edges, visited));
            }   
        }
        
        return res;
    }
    
    private int bfs(Queue<Integer> q, int[] edges, boolean[] visited) {
        Set<Integer> set = new HashSet<>();
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;
            set.add(cur);
            
            if(edges[cur] != -1 && !visited[edges[cur]]) {
                q.offer(edges[cur]);
            }
       //     System.out.println(cur + " : " + set.toString());
            if(set.contains(edges[cur])) {
                q.clear();
                set.clear();
                q.offer(edges[cur]);
                
         //       System.out.println("hi");
                while(!q.isEmpty()) {
                    cur = q.poll();
                    set.add(cur);
                    
                    if(set.contains(edges[cur])) {
                        return set.size();
                    } else {
                        q.offer(edges[cur]);
                        set.add(edges[cur]);
                    }
                }
            }
        }
        
        return -1;
    }
}