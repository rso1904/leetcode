class Solution {
    int[] res;
    int max = 0;
    
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        res = new int[aliceArrows.length];
        int[] b = new int[aliceArrows.length];
        
        search(aliceArrows, b, numArrows, 0, 0);
        
        return res;
    }
    
    private void search(int[] a, int[] b, int na, int cur, int count) {
        if(cur == a.length) {
            if(count > max) {
                if(na > 0) {
                    b[0] += na;
                }
                
                max = count;
                res = Arrays.copyOf(b, b.length);
                b[0] -= na;
            }
            
            return;
        }
        
        search(a, b, na, cur+1, count);
        
        if(na > a[cur]) {
            b[cur] = a[cur] + 1;
            search(a, b, na - (a[cur] + 1), cur+1, count + cur);
            b[cur] = 0;
        }
    }
}