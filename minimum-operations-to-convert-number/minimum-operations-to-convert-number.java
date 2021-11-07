class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[1001];
        
        q.offer(new int[]{start, 0});
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int[] item = q.poll();
            
            if(item[0] == goal) {
                return item[1];
            }
            
            if(item[0] >= 0 && item[0] <= 1000) {
                for(int i=0; i < nums.length; i++) {
                    if(item[0] + nums[i] < 0 || item[0] + nums[i] > 1000 || !visited[item[0] + nums[i]]) {
                        q.offer(new int[]{item[0] + nums[i], item[1] + 1});
                        
                        if(item[0] + nums[i] >= 0 && item[0] + nums[i] <= 1000)
                            visited[item[0] + nums[i]] = true;
                    }
                    
                    if(item[0] - nums[i] < 0 || item[0] - nums[i] > 1000 || !visited[item[0] - nums[i]]) {
                        q.offer(new int[]{item[0] - nums[i], item[1] + 1});
                        
                        if(item[0] - nums[i] >= 0 && item[0] - nums[i] <= 1000)
                            visited[item[0] - nums[i]] = true;
                    }
                    
                    if((item[0] ^ nums[i]) < 0 || (item[0] ^ nums[i]) > 1000 || !visited[item[0] ^ nums[i]]) {
                        q.offer(new int[]{item[0] ^ nums[i], item[1] + 1});
                        
                        if((item[0] ^ nums[i]) >= 0 && (item[0] ^ nums[i]) <= 1000)
                            visited[item[0] ^ nums[i]] = true;
                    }
                }
            }
        }
        
        return -1;
    }
}