class Solution {
    public int makeStringSorted(String s) {
        long total = 0;
        long mod = (long)1e9 + 7;
        long[] count = new long[26];
        long[] fact = new long[s.length()+1];
        
        fact[0] = 1;
        
        for(int i=1; i <= s.length(); i++) {
            fact[i] = (fact[i-1] * i) % mod;
        }
        
        for(int i=s.length()-1; i >= 0; i--) {
            count[s.charAt(i)-'a']++;
            int sum = 0;
            
            for(int j=0; j < s.charAt(i)-'a'; j++)
                sum += count[j];
            
            long value = sum * fact[s.length() - (i + 1)] % mod;
            
            for(int j = 0; j < 26; j++) {
                value = (value * modpow(fact[(int)count[j]], mod - 2, mod)) % mod;
            }
            
            total = (total + value) % mod;
        }
        
        return (int)total;
    }
    
     private long modpow(long a, long n, long mod)
    {
        if(n == 1)
            return a%mod;
        long res = modpow(a, n/2, mod);
        res = res*res%mod;
        if(n % 2 == 1)
            res = res*a%mod;
        return res;
    }
}