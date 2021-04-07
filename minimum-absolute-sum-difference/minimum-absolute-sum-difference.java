class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int mod = (int)1e9+7;
        int index = 0;
        int max = 0;
        
        for(int i=0; i < nums1.length; i++) {
            if(Math.abs(nums1[i] - nums2[i]) > max) {
                max = Math.abs(nums1[i] - nums2[i]);
                index = i;
            }
            
            sum = (sum + Math.abs(nums1[i] - nums2[i])) % mod;
        }
        
        for(int i=0; i < nums2.length; i++) {
            res = Math.min(res, (sum - Math.abs(nums1[index] - nums2[index]) + Math.abs(nums1[i] - nums2[index]) % mod));
        }
        
        return res % mod;
    }
}