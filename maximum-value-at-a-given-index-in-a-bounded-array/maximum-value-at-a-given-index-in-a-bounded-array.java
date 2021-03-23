class Solution {
    public int maxValue(int n, int index, int maxSum) {
        maxSum -= n;
        int left = 0;
        int right = maxSum;
        
        while(left < right) {
            int mid = (left + right + 1) / 2;
            
            if(check(n, index, mid) <= maxSum) {
                left = mid;
            } else {
                right = mid -1;
            }
        }
        
        return left+1;
    }
    
    private long check(int n, int index, int mid) {
        long res = 0;
        int leftValue = Math.max(mid - index, 0);
        res += (long)(leftValue + mid) * (mid - leftValue + 1) / 2;
        int rightValue = Math.max(mid - ((n - 1) - index), 0);
        res += (long)(mid + rightValue) * (mid - rightValue + 1) / 2;
        return res - mid;
    }
}