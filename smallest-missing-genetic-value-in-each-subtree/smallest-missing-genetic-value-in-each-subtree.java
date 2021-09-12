class Solution {
    Set<Integer> visited = new HashSet<>();
    
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        Map<Integer, List<Integer>> adjs = new HashMap<>();
        int[] res = new int[nums.length];
        
        for(int i=1; i < parents.length; i++) {
            if(adjs.get(parents[i]) == null) {
                adjs.put(parents[i], new ArrayList<>());
            }
            
            adjs.get(parents[i]).add(i);
        }
        
        Arrays.fill(res, 1);
        
        int index = -1;
        
        for(int i=0; i < nums.length; i++) {
            if(nums[i] == 1) {
                index = i;
                break;
            }
        }
        
        int miss = 1;
        
        while(index >= 0) {
            dfs(adjs, index, nums);
            
            while(visited.contains(miss)) {
                miss++;
            }
            
            res[index] = miss;
            index = parents[index];
        }
        
        return res;
    }
    
    private void dfs(Map<Integer, List<Integer>> adjs, int cur, int[] nums) {
        if(!visited.contains(nums[cur])) {
            List<Integer> adj = adjs.get(cur);
            
            if(adj != null) {
                for(Integer neib : adj) {
                    dfs(adjs, neib, nums);
                }
            }
            
            visited.add(nums[cur]);
        }
    }
}