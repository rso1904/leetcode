class Solution {
    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        
        return lower(candies, k) - 1;
    }
    
    private int lower(int[] candies, long k) {
        int left = 1;
        int right = 1_000_000_1;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            
            if (!check(mid, candies, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean check(int mid, int[] candies, long k) {
        long res = 0;
        
        for(int i=0; i < candies.length; i++) {
            res += candies[i] / mid;    
        }
                
        return res >= k ? true : false;
    }
}