class Solution {
    public int minCharacters(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int[] aCount = new int[26];
        int[] bCount = new int[26];
        int res = Integer.MAX_VALUE;
        
        for(int i=0; i < a.length(); i++) {
            aCount[a.charAt(i) - 'a']++;
        }
        
        for(int i=0; i < b.length(); i++) {
            bCount[b.charAt(i) - 'a']++;
        }
        
        for(int i=0; i < 26; i++) {
            res = Math.min(res, aLen+bLen-aCount[i]-bCount[i]);
            
            if(i > 0) {
                aCount[i] += aCount[i-1];
                bCount[i] += bCount[i-1];
            }
            
            if(i < 25) {
                res = Math.min(res, aLen - aCount[i] + bCount[i]);
                res = Math.min(res, bLen - bCount[i] + aCount[i]);
            }
        }
        
        return res;
    }
}
