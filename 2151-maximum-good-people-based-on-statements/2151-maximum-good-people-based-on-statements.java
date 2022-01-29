class Solution {
    int res = 0;
    
    public int maximumGood(int[][] statements) {        
        search(statements, 0, 0, 0);
        
        return res;
    }
    
    private void search(int[][] state, int cur, int mask, int count) {
        if(cur >= state.length) {
            if(check(state, mask)) {
                res = Math.max(res, count);
            }
            
            return;
        }
        
        search(state, cur+1, mask, count);
        search(state, cur+1, mask + (1 << cur), count+1);
    }
    
    private boolean check(int[][] state, int mask) {
        int index = 0;
        
        while(mask >= (1 << index)) {
            if((mask & (1 << index)) != 0) {
                for(int i=0; i < state[index].length; i++) {
                    if(state[index][i] != 2 && state[index][i] != ((mask >> i) & 1)) {
                        return false;
                    }
                }
            }
            
            index++;
        }
        
        return true;
    }
}