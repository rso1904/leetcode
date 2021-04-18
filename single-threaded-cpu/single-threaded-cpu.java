class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        int time = 0;
        int[] res = new int[tasks.length];
        int index = 0;
        
        for(int i=0; i < tasks.length; i++) {
            pq.offer(new int[]{tasks[i][0], tasks[i][1], i});
        }
        
        while(!pq.isEmpty() || !pq1.isEmpty()) {
            while (!pq.isEmpty() && pq.peek()[0] <= time) {
                pq1.offer(pq.poll());
            } 
            
            if(!pq1.isEmpty()) {
                int[] item = pq1.poll();
                
                time += item[1];
                res[index++] = item[2];
            } else {
                int[] start = pq.poll();
                time += start[0];
                pq1.offer(start);
            }
        }
        
        return res;
    }
}