class Solution {
    public int findCenter(int[][] edges) {
        int[] count = new int[100001];
        int res = -1;
        int max = 0;
        
        for(int i=0; i < edges.length; i++) {
            count[edges[i][0]]++;
            count[edges[i][1]]++;
            
            if(max < count[edges[i][0]]) {
                max = count[edges[i][0]];
                res = edges[i][0];
            }
            
            if(max < count[edges[i][1]]) {
                max = count[edges[i][1]];
                res = edges[i][1];
            }
        }
        
        return res;
    }
}