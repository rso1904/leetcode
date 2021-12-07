class Solution {
    List<Integer> trail = new ArrayList<>();
    Map<Integer, Integer> indegree = new HashMap<>();
    Map<Integer, Integer> outdegree = new HashMap<>();
    Map<Integer, List<Integer>> adjs = new HashMap<>();
    
    public int[][] validArrangement(int[][] pairs) {
        Set<Integer> set = new HashSet<>();
        int[][] res = new int[pairs.length][2];
        boolean check = false;
        
        for(int i=0; i < pairs.length; i++) {
            outdegree.put(pairs[i][0], outdegree.getOrDefault(pairs[i][0], 0) + 1);
            indegree.put(pairs[i][1], indegree.getOrDefault(pairs[i][1], 0) + 1);
            set.add(pairs[i][0]);
            
            if(adjs.get(pairs[i][0]) == null) {
                adjs.put(pairs[i][0], new ArrayList<>());
            }
            
            adjs.get(pairs[i][0]).add(pairs[i][1]);
        }
        
        for(Integer key : set) {
            int in = indegree.get(key) == null ? 0 : indegree.get(key);
            if(in + 1 == outdegree.get(key)) {
                getEulerCircuit(key);
                check = true;
                break; 
            }
        }
        
        if(!check) {
            for(Integer key : set) {
                int in = indegree.get(key) == null ? 0 : indegree.get(key);
                if(in == outdegree.get(key)) {
                    getEulerCircuit(key);
                    break; 
                }
            }
        }
        
        for(int i = trail.size() - 1; i >= 1; i--) {
            res[trail.size() - 1 - i] = new int[]{trail.get(i), trail.get(i-1)};
        }
        
        return res;
    }
    
    private void getEulerCircuit(int node) {
        List<Integer> adj = adjs.get(node);
        
        if(adj != null) {
            while(adj.size() > 0) {
                int next = adj.get(adj.size()-1);
                adj.remove(adj.size()-1);
                getEulerCircuit(next);
            }
        }
        
        trail.add(node);
    }
}