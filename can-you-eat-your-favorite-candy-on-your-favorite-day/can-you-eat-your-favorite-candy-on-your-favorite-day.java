class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        long[] pSum = new long[candiesCount.length];
        
        for(int i=0; i < candiesCount.length; i++) {
            pSum[i] = i-1 >= 0 ? pSum[i-1] + candiesCount[i] : candiesCount[i];
        }
        
        for(int i=0; i < queries.length; i++) {
            int index = queries[i][0] - 1;
            Long favDay = Long.valueOf(queries[i][1])+1L;
            Long cap = Long.valueOf(queries[i][2]);
            Long comp = favDay * cap;
            
            if((index < 0 || pSum[index] < comp) && pSum[index+1] > queries[i][1]) {
                ans[i] = true;
            } else {
                ans[i] = false;
            }
        }
        
        return ans;
    }
}