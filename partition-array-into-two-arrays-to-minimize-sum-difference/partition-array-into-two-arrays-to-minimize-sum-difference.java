class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, List<Integer>> left = new HashMap<>();
        Map<Integer, List<Integer>> right = new HashMap<>();
        int res = Integer.MAX_VALUE;
        int sum = 0;
        
        for(int i=0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        for(int mask=0; mask < (1 << n); mask++) {
            int size = 0;
            int l = 0;
            int r = 0;
            
            for(int i=0; i < n; i++) {
                if((mask & (1 << i)) != 0) {
                    size++;
                    l += nums[i];
                    r += nums[n + i];
                }
            }
            
            left.computeIfAbsent(size, x -> new ArrayList<>()).add(l);
            right.computeIfAbsent(size, x -> new ArrayList<>()).add(r);
        }
        
        for(int i=0; i <= n; i++) {
            if(right.get(i) != null) {
                Collections.sort(right.get(i));
            }
        }
        
        res = Math.min(Math.abs(sum - 2 * left.get(n).get(0)), Math.abs(sum - 2 * right.get(n).get(0)));
        
        for(int size=1; size < n; size++) {
            for(Integer a : left.get(size)) {
                int b = (sum - 2*a) / 2;
                int rightSize = n - size;
                int index = lowerbound(right.get(rightSize), b);
                
                if(index < right.get(rightSize).size()) {
                    res = Math.min(res, Math.abs(sum - 2 * (a + right.get(rightSize).get(index))));
                }
                
                if(index > 0 && index < right.get(rightSize).size()) {
                    index--;
                    res = Math.min(res, Math.abs(sum - 2 * (a + right.get(rightSize).get(index))));
                }
            }
        }
        
        return res;
    }
    
    private int lowerbound(List<Integer> input, int target) {
        int left = 0;
        int right = input.size();
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            
            if(target <= input.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}