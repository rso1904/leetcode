class Solution {
    public int maxNiceDivisors(int primeFactors) {
        int mod = (int)1e9+7;
        if(primeFactors <= 3) return primeFactors;
        else if(primeFactors % 3 == 0)
            return (int)modpow(3, primeFactors / 3, mod) % mod;
        else if(primeFactors % 3 == 1)
            return (int)(modpow(3, (primeFactors - 4) / 3, mod) * 4 % mod);
        else if(primeFactors % 3 == 2) {
            return (int)(modpow(3, (primeFactors - 2) / 3, mod) * 2 % mod);
        }
        
        return 0;
    }
    
    private long modpow(long base, int exp, int modulus) {
        long result = 1;
        for (; exp > 0; exp >>= 1) {
            if ((exp & 1) == 1)
                result = result * base % modulus;
            base = base * base % modulus;
        }
        
        return result;
    }
}