class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, List<Integer>> adjs = new HashMap<>();
        int[][] dp = new int[colors.length()][26];
        int[] indegree = new int[colors.length()];
        int seen = 0;
        int res = 0;
        
        for(int i=0; i < edges.length; i++) {
            if(adjs.get(edges[i][0]) == null) {
                adjs.put(edges[i][0], new ArrayList<>());
            }
            
            indegree[edges[i][1]]++;
            adjs.get(edges[i][0]).add(edges[i][1]);
        }
        
        for(int i=0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                dp[i][colors.charAt(i)-'a']++;
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()) {
            Integer item = q.poll();
            
            int cur = item;
            seen++;
            
            for(int i=0; i < 26; i++) {
                res = Math.max(res, dp[cur][i]);
            }
            
            if(adjs.get(cur) != null) {
                for(Integer adj : adjs.get(cur)) {
                    for(int i=0; i < 26; i++) {
                        dp[adj][i] = Math.max(dp[adj][i], dp[cur][i] + ((colors.charAt(adj) - 'a') == i ? 1: 0));
                    }
                    if(--indegree[adj] == 0) {
                        q.offer(adj);
                    }
                }
            }
        }
        
        if(seen < colors.length())
            return -1;
        
        return res;
    }
}