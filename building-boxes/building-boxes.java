class Solution {
    public int minimumBoxes(int n) {
        int total = 0;
        int len = 1;
        int ans = 0;
        
        while(total < n) {
            for(int i=1; i <= len; i++) {
                total += i;
                if(total >= n) {
                    ans += i;
                    return ans;
                }
            }    
            ans += len;
            len++;
        }
        
        
        return ans;
    }
}