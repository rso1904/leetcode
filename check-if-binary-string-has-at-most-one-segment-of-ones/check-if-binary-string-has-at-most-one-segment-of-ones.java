class Solution {
    public boolean checkOnesSegment(String s) {
        int check = 0;
        for(int i=1; i < s.length(); i++) {
            if(s.charAt(i-1) != s.charAt(i)) {
                check++;
            }
            
            if(check >= 2)
                return false;
        }
        
        return true;
    }
}