class Solution {
    Map<Integer, List<Integer>> adjs = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Map<Integer, List<int[]>> path = new HashMap<>();
    int[] res;
    
    public int[] getCoprimes(int[] nums, int[][] edges) {
        res = new int[nums.length];
        Arrays.fill(res, -1);
        
        for(int i=0; i < edges.length; i++) {
            if(adjs.get(edges[i][0]) == null) {
                adjs.put(edges[i][0], new ArrayList<>());
            }
            
            if(adjs.get(edges[i][1]) == null) {
                adjs.put(edges[i][1], new ArrayList<>());
            }
            
            adjs.get(edges[i][0]).add(edges[i][1]);
            adjs.get(edges[i][1]).add(edges[i][0]);
        }
        
        dfs(0, 0, nums);
        
        return res;
    }
    
    private void dfs(int node, int depth, int[] nums) {
        if(visited.contains(node)) {
            return;
        }
        
        visited.add(node);
        int largest = -1;
        
        for(int i=1; i <= 50; i++) {
            if(gcd(nums[node], i) == 1 && path.get(i) != null && path.get(i).size() != 0) {
                int anc = path.get(i).get(path.get(i).size()-1)[0];
                int dep = path.get(i).get(path.get(i).size()-1)[1];
                
                if(dep > largest) {
                    largest = dep;
                    res[node] = anc;
                }
            }
        }
        
        if(path.get(nums[node]) == null) {
            path.put(nums[node], new ArrayList<>());
        }
        
        path.get(nums[node]).add(new int[]{node, depth});
        
        if(adjs.get(node) != null) {
            List<Integer> adj = adjs.get(node);
            
            for(Integer neb : adj) {
                dfs(neb, depth+1, nums);
            }
        }
        
        if(path.get(nums[node]) != null) {
            path.get(nums[node]).remove(path.get(nums[node]).size()-1);
        }
    }
    
    private int gcd(int a, int b) {
        if (b == 0)
            return a;
      
        return gcd(b, a % b); 
    }
    
}