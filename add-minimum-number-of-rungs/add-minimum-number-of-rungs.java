class Solution {
    public int addRungs(int[] rungs, int dist) {
        int res = rungs[0] > dist ? 1 : 0;
        int cur = rungs[0] > dist ? dist : rungs[0];
        int index = rungs[0] > dist ? 0 : 1;
        
        for(int i=index; i < rungs.length; i++) {
            if(rungs[i] > dist + cur) {
                res += (rungs[i] - 1 - cur) / dist;
        //        System.out.println(rungs[i]  + " : " + cur);
       //         System.out.println((rungs[i] - 1 - cur) / dist);
        //        System.out.println(res);
                cur = rungs[i];
            } else {
                cur = rungs[i];
            }
        }
        
        return res;
    }
}