class Solution {
    public int maxSumMinProduct(int[] nums) {
        long total = 0;
        int mod = (int)1e9 + 7;
        long[] prefix = new long[nums.length];
        Stack<int[]> stack = new Stack<>();
        
        for(int i=0; i < nums.length; i++) {
            prefix[i] = i == 0 ? nums[i] : prefix[i-1] + nums[i];
        }
        
        for(int i=0; i < nums.length; i++) {
            int start = i;
            
            while(!stack.isEmpty() && nums[i] < stack.peek()[1]) {
                int[] item = stack.pop();
                long prev = item[0] - 1 < 0 ? 0 : prefix[item[0]-1];
                total = Math.max(total, (prefix[i-1] - prev) * item[1]);
                start = item[0];
            }
            
            stack.push(new int[]{start, nums[i]});
        }
        
        while(!stack.isEmpty()) {
            int[] item = stack.pop();
            long prev = item[0] - 1 < 0 ? 0 : prefix[item[0]-1];
            total = Math.max(total, (prefix[prefix.length-1] - prev) * item[1]);
        }
        
        return (int)(total % mod);
    }
}