class Solution {
    public int countEven(int num) {
        int res = 0;
        
        while(num > 0) {
            int value = num;
            int sum = 0;
            
            while(value > 0) {
                sum += value % 10;
                value /= 10;
            }
            
            if(sum % 2 == 0) {
                res++;
            }
            
            num--;
        }
        
        return res;
    }
}