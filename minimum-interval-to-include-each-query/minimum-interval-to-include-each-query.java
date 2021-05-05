class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] res = new int[queries.length];
        int j = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Map<Integer, Integer> map = new HashMap<>();
        int[] original = queries.clone();
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(queries);
        
        for(int i=0; i < queries.length; i++) {
            while(j < intervals.length && intervals[j][0] <= queries[i]) {
                pq.offer(new int[]{intervals[j][1] - intervals[j][0] + 1, intervals[j][1]});
                j++;
            }
            
            while(!pq.isEmpty() && pq.peek()[1] < queries[i]) {
                pq.poll();
            }
            
            map.put(queries[i], pq.isEmpty() ? -1 : pq.peek()[0]);
        }
        
        for(int i=0; i < original.length; i++) {
            res[i] = map.get(original[i]);
        }
        
        return res;
    }
}