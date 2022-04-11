class Solution {    
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        long res = 0;
        long[] need = new long[flowers.length];
        
        Arrays.sort(flowers);
        
        for(int i=1; i < flowers.length; i++) {
            need[i] = (flowers[i] - flowers[i-1]) * (i) + need[i-1];
        }
        
        int j = -1;
        
        for(int i=flowers.length-1; i >=0; i--) {
            if(target > flowers[i]) {
                j = i;
                break;
            }    
        }
        
        for(int i=j; i >= 0 && newFlowers > 0; i--) {
            int index = Math.min(i, upper(need, newFlowers)-1);

            long extraH = (long)(newFlowers - need[index]) / (index + 1);
            long H = Math.min(target-1, flowers[index] + extraH);

            res = Math.max(res, (long)full * (long)(flowers.length - 1 - i) + (long)partial * (long)H);
            newFlowers -= (target - flowers[i]);
        }
        
        if(newFlowers > 0) {
            res = Math.max(res, (long)full * (long)(flowers.length));
        }
        
        return res;
    }
    
    private int upper(long[] input,long target) {
        int left = 0;
        int right = input.length;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            
            if(target < input[mid]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        
        return left;
    }
}