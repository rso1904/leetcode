class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public int maxHappyGroups(int batchSize, int[] groups) {
        int[] count = new int[batchSize];
        int res = 0;
        
        for(int i=0; i < groups.length; i++) {
            if(groups[i] % batchSize == 0) {
                res++;
            } else {
                count[groups[i] % batchSize]++;
            }
        }
        
        for(int i=1; i < batchSize; i++) {
            int value = 0;
            if(i == batchSize - i) {
                value = count[i] / 2;
                count[i] -= value * 2;
            } else {
                value = Math.min(count[i], count[batchSize - i]);
                count[i] -= value;
                count[batchSize - i] -= value;
            }
            
            res += value;
        }
        
        return res + dfs(batchSize, groups, count, 0);
    }
    
    private int dfs(int batchSize, int[] groups, int[] count, int remain) {
        if(map.get(Arrays.toString(count)) != null) {
            return map.get(Arrays.toString(count));
        }
        
        int res = 0;
        
        for(int i=1; i < batchSize; i++) {
            if(count[i] > 0) {
                count[i]--;
                int newRemain = (remain + i) % batchSize;
                int added = remain == 0 ? 1 : 0;
                res = Math.max(res, dfs(batchSize, groups, count, newRemain) + added);
                count[i]++;
            }
        }
        
        map.put(Arrays.toString(count), res);
        
        return res;
    }
}