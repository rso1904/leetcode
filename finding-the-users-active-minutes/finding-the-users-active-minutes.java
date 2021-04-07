class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] res = new int[k];
        
        for(int i=0; i < logs.length; i++) {
            if(map.get(logs[i][0]) == null) {
                map.put(logs[i][0], new HashSet<>());
            }
            
            map.get(logs[i][0]).add(logs[i][1]);
        }
        
        for(Integer key : map.keySet()) {
            res[map.get(key).size()-1]++; 
        }
        
        return res;
    }
}