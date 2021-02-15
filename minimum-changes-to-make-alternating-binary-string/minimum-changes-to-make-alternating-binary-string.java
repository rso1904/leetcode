class Solution {    
    public int minOperations(String s) {
        String first = "";
        String second = "";
        int fres = 0;
        int sres = 0;
        
        for(int i=0; i < s.length(); i++) {
            if(i % 2 == 0) {
                first += "0";
                second += "1";
            } else {
                first += "1";
                second += "0";
            }
            
            if(s.charAt(i) != first.charAt(i)) {
                fres++;
            }
            
            if(s.charAt(i) != second.charAt(i)) {
                sres++;
            }
        }
        
        return Math.min(fres, sres);
    }
}