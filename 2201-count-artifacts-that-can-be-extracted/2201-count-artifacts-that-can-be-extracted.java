class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int[] count = new int[artifacts.length];
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        
        for(int i=0; i < artifacts.length; i++) {
            for(int row=artifacts[i][0]; row <= artifacts[i][2]; row++) {
                for(int col=artifacts[i][1]; col <= artifacts[i][3]; col++) {
                    count[i]++;
                    map.put(row + ":" + col, i);
                }
            }
        }
        
        for(int i=0; i < dig.length; i++) {
            String key = dig[i][0] + ":" +dig[i][1];
            if(map.get(key) != null) {
                count[map.get(key)]--;
            }
        }
        
        for(int i=0; i < count.length; i++) {
            if(count[i] == 0) {
                res++;
            }
        }
        
        return res;
    }
}