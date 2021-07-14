class Solution {
    public int longestCommonSubpath(int n, int[][] paths) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        int ans = 0;
        
        for(int i=0; i < paths.length; i++) {
            if(paths[i].length < right) {
                right = paths[i].length;
            }
        }
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            boolean res = rollingHash(paths, mid);
     //       System.out.println(mid + " : " + res + " : " + left + " : " + right);
            if(res) {
                left = mid+1;
                ans = mid;
            } else {
                right = mid-1;
            }
        }
        
        return ans;
    }
    
    private boolean rollingHash(int[][] paths, int mid) {
        long d = 1;
        long hash = 0;
        long base = 100003;
        long mod = (long)(Math.pow(10,11) + 3);
        Set<Long> set = new HashSet<>();
        
        for(int i=0; i < paths.length; i++) {
            hash = 0;
            d = 1;
            Set<Long> cur = new HashSet<>();
            
            for(int j=0; j < mid; j++) {
                hash = (hash * base % mod + paths[i][j]) % mod;
                if(j < mid-1)
                    d = d * base % mod;
            }
            
       ///     d = d / base % mod;
            
            if(i == 0 || set.contains(hash))
                cur.add(hash);
            
            for(int j=mid; j < paths[i].length; j++) {
                long newhash = (hash - (d % mod * (paths[i][j-mid]) % mod) + mod) % mod;
                newhash = (newhash % mod * base % mod) % mod;
                newhash = (newhash + paths[i][j] % mod) % mod;
                hash = newhash;
                
                if(i == 0 || set.contains(hash))
                    cur.add(hash);
            }
            
            set = new HashSet<>(cur);
        }
        
        return set.isEmpty() ? false : true;
    }
}