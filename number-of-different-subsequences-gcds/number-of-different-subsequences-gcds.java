class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int res = 0;
        int[] gcd = new int[200001];
        
        for(int i=0; i < nums.length; i++) {
            for(int j=1; j * j <= nums[i]; j++) {
                if(nums[i] % j == 0) {
                    int factor = j;
                    int factor1 = nums[i] / j;

                    gcd[factor] = getGcd(gcd[factor], nums[i]);
                    gcd[factor1] = getGcd(gcd[factor1], nums[i]);
                }
            }
        }
        
        for(int i=1; i <= 200000; i++) {
            if(gcd[i] == i) {
                res++;
            }
        }
        
        return res;
    }
    
    private int getGcd(int a, int b) {
        if(b == 0)
            return a;
        return getGcd(b, a % b);
    }
}