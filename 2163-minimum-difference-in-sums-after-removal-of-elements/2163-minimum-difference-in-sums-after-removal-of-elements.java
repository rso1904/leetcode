class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        long[] left = new long[nums.length];
        long[] right = new long[nums.length];
        PriorityQueue<int[]> min = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> max = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        long cur = 0;
        long res = Long.MAX_VALUE;
        
        for(int i=0; i < nums.length; i++) {
            if(i < n) {
                max.offer(new int[]{nums[i], i});
                cur += nums[i];
            } else {
                if(nums[i] < max.peek()[0]) {
                    cur -= max.poll()[0];
                    cur += nums[i];
                    max.offer(new int[]{nums[i], i});
                }
            }
            left[i] = cur;
        }
        
        cur = 0;
        
        for(int i=nums.length-1; i >= 0; i--) {
            if(i > nums.length - 1 - n) {
                min.offer(new int[]{nums[i], i});
                cur += nums[i];
            } else {
                if(nums[i] > min.peek()[0]) {
                    cur -= min.poll()[0];
                    cur += nums[i];
                    min.offer(new int[]{nums[i], i});
                }
            }
            right[i] = cur;
        }
        
        for(int i=n-1; i < nums.length - n; i++) {
            res = Math.min(res, left[i] - right[i+1]);
        }
        
        return res;
    }
}