class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[edges.length];
        Map<Integer, Integer> map = new HashMap<>();
        int minDis = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        
        q.offer(new int[]{node1, 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]] = true;
            map.put(cur[0], cur[1]);
            
            if(edges[cur[0]] != -1 && !visited[edges[cur[0]]]) {
                q.offer(new int[]{edges[cur[0]], cur[1]+1});
            }
        }
        
        q.clear();
        visited = new boolean[edges.length];
        
        q.offer(new int[]{node2, 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]] = true;
        //    System.out.println(cur[0] + " : " + cur[1] + " : " + map.get(cur[0]) + " : " + minDis + " : " + res);
            if(map.containsKey(cur[0]) && Math.max(cur[1],map.get(cur[0])) <= minDis) {
                if(minDis == Math.max(cur[1],map.get(cur[0]))) {
                    if(cur[0] < res) {
                        minDis = Math.max(cur[1],map.get(cur[0]));
                        res = cur[0];
                    }
                } else {
                    minDis = Math.max(cur[1],map.get(cur[0]));
                    res = cur[0];
                }
            }
            
            if(edges[cur[0]] != -1 && !visited[edges[cur[0]]]) {
                q.offer(new int[]{edges[cur[0]], cur[1] + 1});
            }
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}