class Solution {    
    public int[] decode(int[] encoded) {
        int first = 0;
        int n = encoded.length+1;
        int[] res = new int[n];
        
        for(int i=1; i <= n; i++) {
            first ^= i;
        }
        
        for(int i=0; i < encoded.length; i++) {
            if(i % 2 == 1)
                first ^= encoded[i];
        }
        
        res[0] = first;
        
        for(int i=1; i < n; i++) {
            res[i] = encoded[i-1] ^ res[i-1];
        }
        
        return res;
    }
}