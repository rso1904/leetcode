class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> adjs = new HashMap<>();
        int[] degree = new int[n+1];
        int res = Integer.MAX_VALUE;
        
        for(int i=0; i < edges.length; i++) {
            adjs.computeIfAbsent(Math.min(edges[i][0], edges[i][1]), a -> new HashSet<>()).add(Math.max(edges[i][0], edges[i][1]));
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        
        for(Integer cur : adjs.keySet()) {
            Set<Integer> nextAdj = adjs.get(cur);
            
            for(Integer next : nextAdj) {
                Set<Integer> thirdAdj = adjs.get(next);
                
                if(thirdAdj == null) {
                    continue;
                }
                
                for(Integer third : thirdAdj) {
                    if(nextAdj.contains(third)) {
                        res = Math.min(res, degree[cur] + degree[next] + degree[third] - 6);
                    }
                }
            }
        }
        
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}