class Solution {
    int[] uf;
    int[] prime;
    
    public boolean gcdSort(int[] nums) {
        uf = new int[100000+1];
        int[] sortedArr = Arrays.copyOf(nums, nums.length);
        
        Arrays.sort(sortedArr);
        
        for(int i=0; i < 100000+1; i++) {
            uf[i] = i;
        }
        
        makeSieve(100000+1);
        
        for(int i=0; i < nums.length; i++) {
            for(Integer factor : getPrimeFactor(nums[i])) {
                union(nums[i], factor);
            }
        }
        
        for(int i=0; i < nums.length; i++) {
            if(find(nums[i]) != find(sortedArr[i])) {
                return false;
            }
        }
        
        return true;
    }
    
    private Set<Integer> getPrimeFactor(int n) {
        Set<Integer> set = new HashSet<>();
        
        while(n > 1) {
            set.add(prime[n]);
            n /= prime[n];
        }
        
        return set;
    }
    
    private void makeSieve(int len) {
        prime = new int[len];
        
        for(int i=0; i < len; i++) {
            prime[i] = i;
        }
        
        for(int i=2; i * i < len; i++) {
            if(prime[i] == i) {
                for(int j = i * i; j < len; j += i) {
                    prime[j] = i;
                }
            }
        }
    }
    
    private void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        
        if(xRoot != yRoot) {
            uf[xRoot] = yRoot;
        }
    }
    
    private int find(int x) {
        if(uf[x] == x) {
            return x;
        }
        
        return uf[x] = find(uf[x]);
    }
}