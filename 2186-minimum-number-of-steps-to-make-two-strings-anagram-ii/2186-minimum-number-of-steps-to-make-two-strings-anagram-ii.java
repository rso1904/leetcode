class Solution {
    public int minSteps(String s, String t) {
        char[] count = new char[26];
        int len = 0;
        
        for(int i=0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;    
        }
        
        for(int i=0; i < t.length(); i++) {
            if(count[t.charAt(i) - 'a'] > 0) {
                len++;
                count[t.charAt(i) - 'a']--;
            }
        }
        
        return t.length() - len + s.length() - len;
    }
}