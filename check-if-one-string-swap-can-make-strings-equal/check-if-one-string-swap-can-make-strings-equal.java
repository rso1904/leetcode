class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) {
            return true;
        }
        
        int count = 0;
        int[] lower = new int[26];
        
        for(int i=0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
            
            lower[s1.charAt(i) - 'a']++;
            lower[s2.charAt(i) - 'a']--;
        }
        
        for(int i=0; i < 26; i++) {
            if(lower[i] != 0)
                return false;
        }
        
        return count == 2 ? true : false;
    }
}