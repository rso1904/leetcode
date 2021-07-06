class Solution {
    int[] size;
    
    public int waysToBuildRooms(int[] prevRoom) {
        size = new int[prevRoom.length];
        Map<Integer, List<Integer>> adjs = new HashMap<>();
        int mod = (int)1e9 + 7;
        
        for(int i=1; i < prevRoom.length; i++) {
            adjs.computeIfAbsent(prevRoom[i], x -> new ArrayList<>()).add(i);
        }
        
        dfs(adjs, 0);
        
        long fact = 1;
        for(int i=2; i <= prevRoom.length; i++) {
            fact = (fact * i) % mod;
        }
        
        long divide = 1;
        
        for(int i=0; i < prevRoom.length; i++) {
            divide = (divide * size[i]) % mod;
        }
        
        int inverse = power((int)divide, mod - 2, mod);
        
        return (int)((fact * inverse) % mod);
    }
    
    private int dfs(Map<Integer, List<Integer>> adjs, int root) {
        int res = 1;
        
        if(adjs.get(root) != null) {
            for(Integer adj : adjs.get(root)) {
                res += dfs(adjs, adj);
            }
        }
        
        size[root] = res;
        return res;
    }
    
    private int power(int x, int y, int m) {
        if(y == 0)
            return 1;
        long p = power(x, y / 2, m) % m;
        p = p * p % (long)m;
        
        if(y % 2 == 0)
            return (int)p;
        else
            return (int)(((long)x * p) % (long)m);
    }
}