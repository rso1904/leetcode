class Solution {
    public long appealSum(String s) {
        long res = 0;
        int[] prev = new int[26];
        long cur = 0;
        
        for(int i=0; i < s.length(); i++) {
            cur = cur + i+1 - prev[s.charAt(i) - 'a'];
            prev[s.charAt(i) - 'a'] = i+1;
            res += cur;
        }
        
        return res;
    }
}