class Solution {
    public boolean checkZeroOnes(String s) {
        int one = 0;
        int zero = 0;
        int max1 = 0;
        int max0 = 0;
        
        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                max0 = Math.max(max0, zero);
                one++;
                zero = 0;
            } else {
                max1 = Math.max(max1, one);
                zero++;
                one = 0;
            }
        }
        
        max1 = Math.max(max1, one);
        max0 = Math.max(max0, zero);
        
        return max1 > max0 ? true : false;
    }
}