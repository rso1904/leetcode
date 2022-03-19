class Solution {
    public int minMovesToMakePalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int res = 0;
        
        while(sb.length() > 0) {
            int index = sb.indexOf(sb.charAt(sb.length()-1)+"");
            
            if(index == sb.length() - 1) {
                res += sb.length() / 2;
            } else {
                res += index;
                sb.deleteCharAt(index);
            }
            
            sb.deleteCharAt(sb.length()-1);
        }
        
        return res;
    }
}