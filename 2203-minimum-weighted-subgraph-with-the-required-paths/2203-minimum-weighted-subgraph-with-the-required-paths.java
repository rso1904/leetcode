class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        Map<Integer, Map<Integer, Integer>> adjs = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> reverseAdjs = new HashMap<>();
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        Map<Integer, Set<Integer>> visited1 = new HashMap<>();
        
        for(int i=0; i < edges.length; i++) {
            adjs.computeIfAbsent(edges[i][0], x -> new HashMap<>());
            
            if(adjs.get(edges[i][0]).get(edges[i][1]) == null) {
                adjs.get(edges[i][0]).put(edges[i][1], edges[i][2]);
            } else if(edges[i][2] < adjs.get(edges[i][0]).get(edges[i][1])) {
                adjs.get(edges[i][0]).put(edges[i][1], edges[i][2]);
            }
            
            reverseAdjs.computeIfAbsent(edges[i][1], x -> new HashMap<>());
            
            if(reverseAdjs.get(edges[i][1]).get(edges[i][0]) == null) {
                reverseAdjs.get(edges[i][1]).put(edges[i][0], edges[i][2]);
            } else if(edges[i][2] < reverseAdjs.get(edges[i][1]).get(edges[i][0])) {
                reverseAdjs.get(edges[i][1]).put(edges[i][0], edges[i][2]);
            }
        }
        
        long[] w = dijstra(n, adjs, src1);
        long[] w1 = dijstra(n, adjs, src2);

        long comp = w[src2] + w1[dest] < 0 ? Long.MAX_VALUE : w[src2] + w1[dest];
        long comp1 = w1[src1] + w[dest] < 0 ? Long.MAX_VALUE : w1[src1] + w[dest];
        
        long res = Math.min(comp, comp1);
        res = Math.min(res, w[dest] + w1[dest]);
        
        if((w[src2] == Long.MAX_VALUE || w1[dest] == Long.MAX_VALUE) && (w1[src1] == Long.MAX_VALUE || w[dest] == Long.MAX_VALUE) && (w[dest] == Long.MAX_VALUE || w1[dest] == Long.MAX_VALUE)) {
            return -1;
        }
        
        if(res == w[dest] + w1[dest]) {
            long[] temp = dijstra(n, reverseAdjs, dest);
            
            for(int i=0; i < w.length; i++) {
                if(w[i] != Long.MAX_VALUE) {
                    if(w[i] != Long.MAX_VALUE && w1[i] != Long.MAX_VALUE && temp[i] != Long.MAX_VALUE) {
                        res = Math.min(res, w[i] + w1[i] + temp[i]);
                    }
                }
            }
        }

        return res;
    }
    
    private long[] dijstra(int n, Map<Integer, Map<Integer, Integer>> adjs, int src) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> a[1] < b[1] ? -1 : a[1] == b[1] ? 0 : 1);
        long[] dest = new long[n];
        
        for(int i=0; i < n; i++) {
            dest[i] = Long.MAX_VALUE;
        }
        
        pq.offer(new long[]{src, 0});
        
        while(!pq.isEmpty()) {
            long[] cur = pq.poll();
            
            if(dest[(int)cur[0]] < cur[1]) {
                continue;
            }
            
            if(adjs.get((int)cur[0]) == null) {
                continue;
            }
            
            for(Integer edge: adjs.get((int)cur[0]).keySet()) {
                if(cur[1] + adjs.get((int)cur[0]).get(edge) < dest[edge]) {
                    dest[edge] = cur[1] +  adjs.get((int)cur[0]).get(edge);
                    pq.offer(new long[]{edge, cur[1] + adjs.get((int)cur[0]).get(edge)});
                }
            }
        }
        
        return dest;
    }
}