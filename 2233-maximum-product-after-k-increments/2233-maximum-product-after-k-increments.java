class Solution {
    public int maximumProduct(int[] nums, int k) {
        long mod = (long)1e9 + 7;
        long res = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int i=0; i < nums.length; i++) {
            if(count.get(nums[i]) == null) {
                pq.offer(nums[i]);
            }
            
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }
        
        while(k > 0 && pq.size() > 1) {
            int prev = pq.poll();
            int next = pq.poll();
            
            int value = (next - prev) * count.get(prev);
            
            if(k >= value) {
                k -= value;
                pq.offer(next);
                count.put(next, count.getOrDefault(next, 0) + count.getOrDefault(prev, 0));
            } else {
                pq.offer(prev);
                pq.offer(next);
                break;
            }
        }
        
        int cc = 0;
        int cur = pq.poll();
        int c = count.get(cur);
        
        for(int i=0; i < nums.length; i++) {
            if(cc < c) {
                nums[i] = cur;
                cc++;
            } else {
                cc = 0;
                cur = pq.poll();
                c = count.get(cur);
                nums[i] = cur;
                cc++;
            }
        }
        int index = 0;
        
        for(int i=0; i < nums.length-1; i++) {
            if(nums[i] != nums[i+1]) {
                index = i;
                break;
            }
        }
        
        if(index == 0) {
            if(nums.length > 1 && nums[nums.length-2] == nums[nums.length-1]) {
                index = nums.length-1;
            }
        }
        
        int ii = 0;
        
        while(k > 0) {
            if(ii > index) {
                ii = 0;
            } else {
                nums[ii]++;
                ii++;
                k--;
            }
        }
        
        for(int i=0; i < nums.length; i++) {
      //      System.out.println(i + " : " + nums[i]);
            res *= (long)nums[i] % mod;
            res %= mod;
        }
        
        return (int)(res % mod);
    }
}