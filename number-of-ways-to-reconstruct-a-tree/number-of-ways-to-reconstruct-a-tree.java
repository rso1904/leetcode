class Solution {
    public int checkWays(int[][] pairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i < pairs.length; i++) {
            if(map.get(pairs[i][0]) == null) {
                map.put(pairs[i][0], new ArrayList<>());
            }
​
            if(map.get(pairs[i][1]) == null) {
                map.put(pairs[i][1], new ArrayList<>());
            }
            
            map.get(pairs[i][0]).add(pairs[i][1]);
            map.get(pairs[i][1]).add(pairs[i][0]);
        }
        
        
        return search(map, new ArrayList<>(map.keySet()), map.keySet().size());
    }
    
    private Integer search(Map<Integer, List<Integer>> map, List<Integer> nodes, int nodeSize) {
        Map<Integer, List<Integer>> degree = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        Map<Integer, List<Integer>> comp = new HashMap<>();
        List<Integer> cand = new ArrayList<>();
        
        for(Integer node : nodes) {
            int deg = map.get(node).size();
            if(degree.get(deg) == null) {
                degree.put(deg, new ArrayList<>());
            }
            degree.get(deg).add(node);
        }
        
        if(degree.get(nodeSize-1) == null)
            return 0;
        int root = degree.get(nodeSize-1).get(0);
        
        for(Integer neibor : map.get(root)) {
            for(int i=0; i < map.get(neibor).size(); i++) {
                if(map.get(neibor).get(i).equals(root)) {
                    map.get(neibor).remove(i);
                }
            }
         //   map.get(neibor).remove(root);
        }
        
        int index = 0;
        
        for(Integer node : nodes) {
            if(!seen.contains(node) && node != root) {
                dfs(node, map, seen, comp, index++);
            }
        }
        
        for(Integer key : comp.keySet()) {
            cand.add(search(map, comp.get(key), comp.get(key).size()));
        }
​
