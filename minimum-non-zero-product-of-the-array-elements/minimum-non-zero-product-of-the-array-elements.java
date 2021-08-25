class Solution {
    public int minNonZeroProduct(int p) {
        long mod = (long)1e9 + 7;
        long maxNumber = 1L<<p;

        return (int)(((maxNumber - 1) % mod * modPow((maxNumber - 2) % mod, maxNumber / 2 - 1, mod)) % mod);   
    }
    
    private long modPow(long base, long pow, long mod) {
        if(pow == 0)
            return 1;
        
        if(pow == 1) {
            return base;
        }
        
        long res = modPow(base, pow / 2, mod);
        
        if(pow % 2 == 0) {
            res = (res * res) % mod;
        } else {
            res = (res * res) % mod;
            res = (base * res) % mod;
        }
        
        return res;
    }
}