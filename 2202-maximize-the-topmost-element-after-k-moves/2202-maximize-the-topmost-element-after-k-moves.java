class Solution {
    public int maximumTop(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        if(k > nums.length) {
            for(int i=0; i < nums.length; i++) {
                pq.offer(nums[i]);
            }
            
            if(nums.length == 1 && k % 2 == 1)
                return -1;
            
            return pq.poll();
        } else {
            for(int i=0; i < k-1; i++) {
                pq.offer(nums[i]);
            }
            
            if(k == nums.length) {
                if(pq.size() == 0)
                    return -1;
                
                return pq.poll();
            } else {
                if(pq.size() == 0)
                    return nums[k];
                
                return Math.max(pq.poll(), nums[k]);
            }
        }
    }
}