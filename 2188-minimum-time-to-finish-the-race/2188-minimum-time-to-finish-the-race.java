class Solution {
    int[] best;
    int[] mem;
    int maxLaps = 0;
    
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        best = new int[numLaps+1];
        mem = new int[numLaps+1];
        Arrays.fill(best, Integer.MAX_VALUE);
        
        for(int i=0; i < tires.length; i++) {
            int pow = 1;
            int sum = tires[i][0];
            
            for(int j=1; j <= numLaps && tires[i][0] * pow < changeTime + tires[i][0]; j++) {
                maxLaps = Math.max(maxLaps, j);
                best[j] = Math.min(best[j], sum);
                pow *= tires[i][1];
                sum += tires[i][0] * pow;
            }
        }
        
        return search(changeTime, numLaps, 0) - changeTime;
    }
    
    private int search(int changeTime, int numLaps, int count) {
        if(count >= numLaps) {
            return 0;
        }
        
        if(mem[count] != 0) {
            return mem[count];
        }
        
        int res = Integer.MAX_VALUE;
        
        for(int i=1; i <= Math.min(numLaps - count, maxLaps); i++) {
            res = Math.min(res, search(changeTime, numLaps, count + i) + changeTime + best[i]);
        }
        
        mem[count] = res;
        
        return res;
    }
}