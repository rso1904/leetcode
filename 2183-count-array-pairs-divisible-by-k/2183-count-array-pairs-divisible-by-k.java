class Solution {
    public long countPairs(int[] nums, int k) {
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i < nums.length; i++) {
            int value = gcd(nums[i], k);
            int extra = k / value;
            
            for(Integer item : map.keySet()) {
                if(value % item == 0) {
                    res += map.get(item);
                }
            }
            
            map.put(extra, map.getOrDefault(extra, 0)+1);
        }
        
        return res;
    }

    private int gcd(int a, int b) {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
}