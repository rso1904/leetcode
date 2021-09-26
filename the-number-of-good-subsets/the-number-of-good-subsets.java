class Solution {
    long[][] mem = new long[1024][31];
    int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    Set<Integer> bad = new HashSet<>(Arrays.asList(4, 8, 9, 12, 16, 18, 20, 24, 25, 27, 28));
    int[] count = new int[31];
    int mod = (int)1e9+7;
    int[] bit = new int[31];

    public int numberOfGoodSubsets(int[] nums) {
        int res = 0;
        long one = 1L;
        
        for(int i=0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        
        for(int i=1; i < 31; i++) {
            int total = 0;
            
            for(int j=0; j < prime.length; j++) {
                if(i % prime[j] == 0) {
                    total += 1 << j;
                }
            }
            
            bit[i] = total;
        }
        
        for(int i=0; i < count[1]; i++) {
            one *= 2L;
            one %= mod;
        }
        
        res = (int)(((dp(1023, 30) - 1) * one) % mod);
        return res;
    }
    
    private long dp(int mask, int num) {
        if(num == 1)
            return 1;
        
        if(mem[mask][num] != 0) {
            return mem[mask][num];
        }
        
        long ans = dp(mask, num-1);
        
        if(!bad.contains(num) && ((mask | bit[num]) == mask)) {
            ans += dp(mask ^ bit[num], num-1) * count[num];
        }
        
        mem[mask][num] = ans % mod;
        
        return mem[mask][num];
    }
}