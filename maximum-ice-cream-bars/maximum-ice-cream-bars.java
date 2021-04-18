class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        
        int res = 0;
        
        for(int i=0; i < costs.length; i++) {
            if(costs[i] <= coins) {
                coins -= costs[i];
                res++;
            } else {
                return res;
            }
        }
        
        return res;
    }
}