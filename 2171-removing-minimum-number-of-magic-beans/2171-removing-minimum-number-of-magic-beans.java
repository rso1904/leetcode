class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        
        long[] prefix = new long[beans.length];
        int n = beans.length;
        long res = Long.MAX_VALUE;
        
        for(int i=0; i < beans.length; i++) {
            prefix[i] = i == 0 ? beans[i] : prefix[i-1] + beans[i];
        }
        
        if(n >= 2) {
            if(beans[n - 1] - beans[0] > prefix[n - 2]) {
                return prefix[n - 2];
            }
        }
        
        
        for(int i=0; i < beans.length; i++) {
            long diff = (long)beans[i] * (long)(n - i);
            long prev = i-1 >= 0 ? prefix[i-1] : 0;
            res = Math.min(res, (prefix[n-1] - prev - diff) + prev);
        }
        
        return res == Long.MAX_VALUE ? 0 : res;
    }
}