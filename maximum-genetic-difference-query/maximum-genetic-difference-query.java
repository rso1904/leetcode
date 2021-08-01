class Solution {
    TrieNode root = new TrieNode();
    int[] ans;
    
    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        Map<Integer, List<Integer>> adjs = new HashMap<>();
        Map<Integer, List<int[]>> query = new HashMap<>();
        ans = new int[queries.length];
        int start = 0;
        
        for(int i=0; i < parents.length; i++) {
            if(parents[i] == -1) {
                start = i;
            }
            
            adjs.computeIfAbsent(parents[i], x -> new ArrayList<>()).add(i);
        }
        
        for(int i=0; i < queries.length; i++) {
            query.computeIfAbsent(queries[i][0], x -> new ArrayList<>()).add(new int[]{queries[i][1], i});
        }
        
        dfs(start, adjs, query);
        
        return ans;
    }
    
    public void dfs(int cur, Map<Integer, List<Integer>> adjs, Map<Integer, List<int[]>> query) {
        root.increase(cur, 1);
        
        if(query.get(cur) != null) {
            for(int[] q : query.get(cur))
                ans[q[1]] = root.findMax(q[0]);
        }
        
        if(adjs.get(cur) != null) {
            for(Integer adj : adjs.get(cur)) {
                dfs(adj, adjs, query);
            }
        }
        
        root.increase(cur, -1);
    }
}

class TrieNode {
    int count = 0;
    TrieNode[] child = new TrieNode[2];
    
    public void increase(int number, int count) {
        TrieNode cur = this;
        
        for(int i=17; i >= 0; i--) {
            int bit = (number >> i) & 1;
            
            if(cur.child[bit] == null) {
                cur.child[bit] = new TrieNode();
            }
            
            cur.child[bit].count += count;
            cur = cur.child[bit];
        }
    }
    
    public int findMax(int number) {
        TrieNode cur = this;
        int ans = 0;
        
        for(int i=17; i >= 0; i--) {
            int bit = (number >> i) & 1;
            
            if(cur.child[1 - bit] != null && cur.child[1 - bit].count > 0) {
                cur = cur.child[1 - bit];
                ans |= 1 << i;
            } else {
                cur = cur.child[bit];
            }
        }
        
        return ans;
    }
}