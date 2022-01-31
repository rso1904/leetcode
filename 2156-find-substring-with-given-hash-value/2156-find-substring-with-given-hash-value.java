class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long value = 0;
        long pow = 1;
        int res = 0;
        
        for(int i=s.length()-1; i >= 0; i--) {
            value = (value * power + (s.charAt(i) - 'a' + 1)) % modulo;
            
            if(i + k >= s.length()) {
                pow *= power;
                pow %= modulo;
            } else {
                value = (value - ((s.charAt(i + k) - 'a' + 1) * pow) % modulo + modulo) % modulo;
            }
                        
            if(value == hashValue) {
                res = i;
            }
        }
        
        return s.substring(res, res + k);
    }
}