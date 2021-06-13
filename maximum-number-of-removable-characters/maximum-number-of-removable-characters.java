class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        
        int left = 0;
        int right = removable.length;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            for(int i=0; i < mid; i++) {
                ss[removable[i]] = '#';
            }
            
            if(check(ss, pp)) {
                left = mid+1;
            } else {
                right = mid-1;
            }
            
            for(int i=0; i < mid; i++) {
                ss[removable[i]] = s.charAt(removable[i]);
            }
        }
        
        return right;
    }
    
    private boolean check(char[] s, char[] p) {
        int i = 0;
        int j = 0;
        
        while(i < s.length && j < p.length) {
            if(s[i] != '#' && s[i] == p[j]) {
                j++;
            }
            i++;
        }
        
        if(j == p.length) {
            return true;
        }
        
        return false;
    }
}