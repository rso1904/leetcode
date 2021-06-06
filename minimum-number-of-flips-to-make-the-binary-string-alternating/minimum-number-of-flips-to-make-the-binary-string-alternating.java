class Solution {
    public int minFlips(String s) {
        int add = 1;
        int one = 0;
        int zero = 0;
        int res = Integer.MAX_VALUE;
        
        char o = '1';
        char z = '0';
        
        for(int i=0; i < s.length(); i++) {
            if(add == 1) {
                if(o != s.charAt(i)) {
                    one++;
                }

                if(z != s.charAt(i)) {
                    zero++;
                }
                    
                add = 0;
            } else {
                if(z != s.charAt(i)) {
                    one++;
                }

                if(o != s.charAt(i)) {
                    zero++;
                }
                    
                add = 1;
            }
        }
        
        res = Math.min(res, Math.min(one, zero));
        
        if(s.length() == 1)
            return res;
        
        String oo = s.length() % 2 == 0 ? "0" : "1";
        String zz = s.length() % 2 == 0 ? "1" : "0";
        char co = '1';
        char cz = '0';
        int start = 0;
        int end = s.length()-2;
        char prev = s.charAt(start);
        char last = s.charAt(end);
        
        for(int k=1; k < s.length(); k++) {
            prev = s.charAt(start);
            last = prev;
            int tempO = one;
            int tempZ = zero;
            
            if(oo.charAt(0) == last) {
                if(prev != cz)
                    one = tempZ - 1;
                else {
                    one = tempZ;
                }
            } else {
                if(prev != cz)
                    one = tempZ;
                else {
                    one = tempZ + 1;
                }
            }
            
            if(zz.charAt(0) == last) {
                if(prev != co)
                    zero = tempO - 1;
                else {
                    zero = tempO;
                }
            } else {
                if(prev != co)
                    zero = tempO;
                else {
                    zero = tempO + 1;
                }
            }

            start++;
            end--;
            res = Math.min(res, Math.min(one, zero));
        }
        
        return res;
    }
}