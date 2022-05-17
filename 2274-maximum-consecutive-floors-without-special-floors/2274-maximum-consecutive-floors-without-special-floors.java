class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int res = 0;
        
        Arrays.sort(special);
        
        for(int i=0; i < special.length; i++) {
            res = Math.max(res, special[i] - 1 - bottom + 1);
            bottom = special[i] + 1;
        }
        
        res = Math.max(res, top - bottom + 1);
        
        return res;
    }
}