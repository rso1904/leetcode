class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        Map<Integer, List<Integer>> adjs = new HashMap<>();
        Map<Integer, List<Integer>> rest = new HashMap<>();
        boolean[] res = new boolean[requests.length];
        
        for(int i=0; i < restrictions.length; i++) {
            rest.computeIfAbsent(restrictions[i][0], x -> new ArrayList<>()).add(restrictions[i][1]);
            rest.computeIfAbsent(restrictions[i][1], x -> new ArrayList<>()).add(restrictions[i][0]);
        }
        
        for(int i=0; i < requests.length; i++) {
            adjs.computeIfAbsent(requests[i][0], x -> new ArrayList<>()).add(requests[i][1]);
            adjs.computeIfAbsent(requests[i][1], x -> new ArrayList<>()).add(requests[i][0]);
            Set<Integer> nodes = bfs(adjs, requests[i][0], n);

            res[i] = true;
            
            for(int j=0; j < restrictions.length; j++) {
                if(nodes.contains(restrictions[j][0]) && nodes.contains(restrictions[j][1])) {
                    res[i] = false;
                    break;
                }
            }
            
            if(!res[i]) {
                if(adjs.get(requests[i][0]) != null) {
                    adjs.get(requests[i][0]).remove(adjs.get(requests[i][0]).size()-1);
                }
                
                if(adjs.get(requests[i][1]) != null) {
                    adjs.get(requests[i][1]).remove(adjs.get(requests[i][1]).size()-1);
                }
            }
            
        }
        
        return res;
    }
    
    private Set<Integer> bfs(Map<Integer, List<Integer>> adjs, int start, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        Set<Integer> res = new HashSet<>();
        
        q.offer(start);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            res.add(cur);
            
            if(!visited[cur] && adjs.get(cur) != null) {
                for(Integer adj : adjs.get(cur)) {
                    q.offer(adj);
                }
            }
            
            visited[cur] = true;
        }
        
        return res;
    }
}