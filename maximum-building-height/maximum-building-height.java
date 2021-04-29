class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);
        
        int res = 0;
        int prevIndex = 1;
        int prevH = 0;
        
        for(int i=0; i < restrictions.length; i++) {
            restrictions[i][1] = Math.min(restrictions[i][1], prevH + (restrictions[i][0] - prevIndex));
            prevIndex = restrictions[i][0];
            prevH = restrictions[i][1];
        }
        
        int lastH = Math.min(n-1, prevH + (n - prevIndex));
        
        prevIndex = n;
        prevH = n-1;
        
        for(int i=restrictions.length - 1; i >= 0; i--) {
            restrictions[i][1] = Math.min(restrictions[i][1], prevH + (prevIndex - restrictions[i][0]));
            prevIndex = restrictions[i][0];
            prevH = restrictions[i][1];
        }
        
        prevIndex = 1;
        prevH = 0;
        
        for(int i=0; i < restrictions.length; i++) {
            int curH = restrictions[i][1];
            int curIndex = restrictions[i][0];
            
            res = Math.max(res, curH + (prevH + (curIndex - prevIndex) - curH) / 2);   
            
            prevIndex = restrictions[i][0];
            prevH = restrictions[i][1];
        }
        
        res = Math.max(res, lastH + (prevH + (n - prevIndex) - lastH) / 2);
                           
        return res;
    }
}