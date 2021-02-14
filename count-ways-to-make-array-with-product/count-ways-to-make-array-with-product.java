class Solution {
    public int[] waysToFillArray(int[][] queries) {
        List<Integer> prime = new ArrayList<>();
        boolean[] check = new boolean[10001];
        int[][] comb = new int[10014][14];
        int[] res = new int[queries.length];
        int mod = 1000000007;
        
        for(int i=2; i * i < 10001; i++) {
            if(!check[i]) {
                prime.add(i);
            }
            
            for(int j=i*i; j < 10001; j += i) {
                if(j == 229) 
                    System.out.println(i);
                check[j] = true;
            }
        }
        
        comb[0][0] = 1;
        
        for(int i=1; i < 10014; i++) {
            for(int j=0; j < 14; j++) {
                comb[i][j] = j == 0 ? 1 : (comb[i-1][j-1] + comb[i-1][j]) % mod;
            }
        }
        
        for(int i=0; i < queries.length; i++) {
            int size = queries[i][0];
            int value = queries[i][1];
            res[i] = 1;
            
            for(int j=0; j < prime.size(); j++) {
                int item = prime.get(j);
                int freq = 0;
                
                while(value % item == 0) {
                    freq++;
                    value /= item;
                }
                
                long multi = (long)res[i] * (long)comb[size + freq - 1][freq] % (long)mod;
                res[i] = (int)multi;
            }
            
            if(value != 1) {
                long multi = (long)res[i] * (long)size % (long)mod;
                res[i] = (int)multi;
            }
        }
                
        return res;
    }
}