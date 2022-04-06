class Solution {
    public long sumScores(String s) {
        int[] z = zFunction(s);
        long res = s.length();
        
        for(int i=0; i < z.length; i++) {
            res += z[i];
        }
        
        return res;
    }
    
    private int[] zFunction(String s) {
        int[] z = new int[s.length()];
        int l = 0;
        int r = 0;
        
        for(int i=1; i < s.length(); i++) {
            if(i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            
            while(i + z[i] < s.length() && s.charAt(i + z[i]) == s.charAt(z[i])) {
                z[i]++;
            }
                
            if(r < i + z[i]) {
                r = i + z[i] - 1;
                l = i;
            }
        }
        
        return z;
    }
}