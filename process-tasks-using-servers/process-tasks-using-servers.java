class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> sq = new PriorityQueue<>((a, b) -> a[1] - b[1] == 0 ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<int[]> rq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int time = 0;
        int index = 0;
        int[] res = new int[tasks.length];
        
        for(int i=0; i < servers.length; i++) {
            sq.offer(new int[]{i, servers[i], 0});
        }
        
        
        while(index < tasks.length) {
            while(!rq.isEmpty() && time >= rq.peek()[2]) {
                int[] in = rq.poll();
                
                sq.offer(new int[]{in[0], in[1]});
            }
            
            while(!sq.isEmpty() && index < tasks.length && time >= index) {
                int[] item = sq.poll();
                
                rq.offer(new int[]{item[0], item[1], time + tasks[index]});
                
                res[index++] = item[0];
            }
            
            if(!rq.isEmpty() && time >= tasks.length)
                time = rq.peek()[2];
            else
                time++;
            
       //     System.out.println(time);
        }
        
        return res;
    }
}