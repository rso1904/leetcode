class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        PriorityQueue<Integer>[] pq = new PriorityQueue[scores.length];
        
        for(int i=0; i < scores.length; i++) {
            pq[i] = new PriorityQueue<>((a, b) -> scores[a] - scores[b]);
        }
        
        for(int i=0; i < edges.length; i++) {
            pq[edges[i][0]].offer(edges[i][1]);
            pq[edges[i][1]].offer(edges[i][0]);
            
            if(pq[edges[i][0]].size() > 3) {
                pq[edges[i][0]].poll();
            }
            
            if(pq[edges[i][1]].size() > 3) {
                pq[edges[i][1]].poll();
            }
        }
        
        int res = -1;
        
        for(int i=0; i < edges.length; i++) {
            for(Integer adj : pq[edges[i][0]]){
                for(Integer adj1 : pq[edges[i][1]]) {
                    if(!adj.equals(adj1) && edges[i][0] != adj1 && edges[i][1] != adj) {
                        res = Math.max(res, scores[edges[i][0]] + scores[edges[i][1]] + scores[adj] + scores[adj1]);    
                    }
                }
            }
        }
        
        return res;
    }
}