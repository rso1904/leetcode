class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int time = 0;
        int[] res = new int[tasks.length];
        int index = 0;
        
        for(int i=0; i < tasks.length; i++) {
            pq.offer(new int[]{tasks[i][0], tasks[i][1], i});
        }
        
        while(!pq.isEmpty() || !pq1.isEmpty()) {
            if(time == 0) {
                int[] start = pq.poll();
                time += start[0];
                pq1.offer(start);
                continue;
            }

            while (!pq.isEmpty() && pq.peek()[0] <= time) {
                pq1.offer(pq.poll());
            } 
            
            if(!pq1.isEmpty()) {
                int[] item = pq1.poll();
                List<int[]> temp = new ArrayList<>();
                
                while(!pq1.isEmpty() && item[1] == pq1.peek()[1]) {
                    if(pq1.peek()[2] < item[2]) {
                        temp.add(item);
                        item = pq1.poll();
                    } else {
                        temp.add(pq1.poll());
                    }
                }
                
                time += item[1];
                res[index++] = item[2];
                
                for(int[] t : temp) {
                    pq1.offer(t);
                }
            } else {
                int[] start = pq.poll();
                time += start[0];
                pq1.offer(start);
                continue;
            }
        }
        
        return res;
    }
}