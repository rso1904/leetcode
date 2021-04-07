class Solution {
    public String truncateSentence(String s, int k) {
        String res = "";
        String[] arr= s.split(" ");
        
        for(int i=0; i < k ; i++) {
            res += arr[i];
            
            if(i != k-1) {
                res += " ";
            }
        }
        
        return res;
    }
}