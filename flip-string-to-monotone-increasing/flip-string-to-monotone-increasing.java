class Solution {
    public int minFlipsMonoIncr(String s) {
        int[][] left = new int[2][s.length()];
        int[][] right = new int[2][s.length()];
        int res = Integer.MAX_VALUE;
        
        for(int i=0; i < s.length(); i++) {
            if(i == 0) {
                if(s.charAt(i) == '0') {
                    left[0][i] = 0;
                    left[1][i] = 1;
                } else {
                    left[0][i] = 1;
                    left[1][i] = 0;
                }
            } else {
                if(s.charAt(i) == '0') {
                    left[0][i] = left[0][i-1];
                    left[1][i] = left[1][i-1] + 1;
                } else {
                    left[0][i] = left[0][i-1] + 1;
                    left[1][i] = left[1][i-1];
                }
            }
        }
        
        for(int i=s.length()-1; i >= 0; i--) {
            if(i == s.length()-1) {
                if(s.charAt(i) == '0') {
                    right[0][i] = 0;
                    right[1][i] = 1;
                } else {
                    right[0][i] = 1;
                    right[1][i] = 0;
                }
            } else {
                if(s.charAt(i) == '0') {
                    right[0][i] = right[0][i+1];
                    right[1][i] = right[1][i+1] + 1;
                } else {
                    right[0][i] = right[0][i+1] + 1;
                    right[1][i] = right[1][i+1];
                }
            }
        }
        
        for(int i=0; i < s.length()-1; i++) {
            res = Math.min(res, left[0][i]+right[1][i+1]);
            res = Math.min(res, left[0][i]+right[0][i+1]);
        }
        
        res = Math.min(res, left[0][s.length()-1]);
        res = Math.min(res, left[1][s.length()-1]);
        
        return res;
    }
}