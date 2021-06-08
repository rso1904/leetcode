class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        long res = Long.MAX_VALUE;
        long[] prefix = new long[packages.length];
        long mod = (long)1e9 + 7;
        Arrays.sort(packages);
        
        for(int i=0; i < packages.length; i++) {
            prefix[i] = i == 0 ? packages[i] % mod : (long)(prefix[i-1] + (long)packages[i]);
        }
        
        for(int i=0; i < boxes.length; i++) {
            TreeMap<Integer, Integer> index = new TreeMap<>();
            
            for(int j=0; j < boxes[i].length; j++) {
                int ind = lower(packages, boxes[i][j]+1);
                ind -= 1;
                
                if(ind >= 0 && (index.get(ind) == null || boxes[i][j] <= index.get(ind))) {
                    index.put(ind, boxes[i][j]);
                }
            }
            
            if(index.get(packages.length-1) == null)
                continue;
            
            int prev = -1;
            long value = 0;
            
            for(Integer key : index.keySet()) {
                long minus = prev == -1 ? prefix[key] : (prefix[key] - prefix[prev]);
                value = (value + ((key.longValue() - (long)prev) * index.get(key).longValue()));
                value = (value - minus);
                prev = key;
            }

            res = Math.min(res, value);
        }
        
        return res == Long.MAX_VALUE ? (int)-1 : (int)(res % mod);
    }
    
    private int lower(int[] packages, int target) {
        int left = 0;
        int right = packages.length;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            
            if(target > packages[mid]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}