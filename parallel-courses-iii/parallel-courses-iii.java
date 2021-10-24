class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] degree = new int[n+1];
        Map<Integer, List<Integer>> adjs = new HashMap<>();
        Queue<int[]> q = new LinkedList<>();
        int[] max = new int[n+1];
        int res = 0;
        
        for(int i=0; i < relations.length; i++) {
            degree[relations[i][1]]++;
            adjs.computeIfAbsent(relations[i][0], x -> new ArrayList<>()).add(relations[i][1]);
        }
        
        for(int i=1; i < degree.length; i++) {
            if(degree[i] == 0) {
                q.offer(new int[]{i, time[i-1]});
                max[i] = Math.max(max[i], time[i-1]);
                res = Math.max(res, max[i]);
            }
        }
        
        while(!q.isEmpty()) {
            int[] item = q.poll();
            
            List<Integer> adj = adjs.get(item[0]);
            
            if(adj != null) {
                for(Integer nei : adj) {
                    degree[nei]--;
                    max[nei] = Math.max(max[nei], item[1] + time[nei-1]);
                    res = Math.max(res, max[nei]);
                    
                    if(degree[nei] == 0) {
                        q.offer(new int[]{nei, max[nei]});
                    }
                }
            }
        }
        
        return res;
    }
}