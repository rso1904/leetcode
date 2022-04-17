class Solution {
    Map<Integer, List<Integer>> mem = new HashMap<>();
    
    public int longestPath(int[] parent, String s) {
        Map<Integer, List<Integer>> adjs = new HashMap<>();
        int res = 0;
        
        for(int i=1; i < parent.length; i++) {
            adjs.computeIfAbsent(parent[i], x -> new ArrayList<>()).add(i);
        }
        
        for(int i=0; i < parent.length; i++) {
            cal(adjs, s, i);
        }
        
        return search(adjs, 0);
    }
    
    private int search(Map<Integer, List<Integer>> adjs, int cur) {
        List<Integer> list = mem.get(cur);
        
        int res = list.get(0) + list.get(1) + 1;
        
        if(adjs.get(cur) != null) {
            for(Integer adj : adjs.get(cur)) {
                res = Math.max(res, search(adjs, adj));
            }
        }
        
        return res;
    }
    
    private int cal(Map<Integer, List<Integer>> adjs, String s, int cur) {
        int res = 0;
        int max = 0;
        int nextMax = 0;
        
        if(mem.get(cur) != null) {
            return mem.get(cur).get(0) + 1;
        }
        
        if(adjs.get(cur) != null) {
            for(Integer adj : adjs.get(cur)) {
                if(s.charAt(cur) != s.charAt(adj)) {
                    int value = cal(adjs, s, adj);
                    
                    if(value > max) {
                        nextMax = max;
                        max = value;
                    } else if(value > nextMax) {
                        nextMax = value;
                    }
                } 
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(max);
        list.add(nextMax);
        mem.put(cur, list);
        
        return max + 1;
    }
}