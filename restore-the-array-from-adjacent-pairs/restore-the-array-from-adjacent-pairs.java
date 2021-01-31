class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        LinkedList<Integer> list = new LinkedList<>();
        boolean[] visited = new boolean[100000+1];
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int start = 0;
        
        for(int i=0; i < adjacentPairs.length; i++) {
            map.put(adjacentPairs[i][0], map.getOrDefault(adjacentPairs[i][0], 0)+1);
            map.put(adjacentPairs[i][1], map.getOrDefault(adjacentPairs[i][1], 0)+1);
            
            if(adj.get(adjacentPairs[i][0]) == null) {
                adj.put(adjacentPairs[i][0], new ArrayList<>());
            }
            
            if(adj.get(adjacentPairs[i][1]) == null) {
                adj.put(adjacentPairs[i][1], new ArrayList<>());
            }
            
            adj.get(adjacentPairs[i][0]).add(adjacentPairs[i][1]);
            adj.get(adjacentPairs[i][1]).add(adjacentPairs[i][0]);
        }
        
        for(Integer key: map.keySet()) {
            if(map.get(key) == 1) {
                start = key;
                break;
            }
        }
        
        list.add(start);
        search(adj, start, Integer.MIN_VALUE, list);  
        
        return list.stream().mapToInt(i->i).toArray();
    }
    
    private void search(Map<Integer, List<Integer>> adj, int cur, int prev, List<Integer> list) {
        if(list.size() >= adj.keySet().size()) {
            return;
        }
        
        for(Integer item : adj.get(cur)) {
            if(prev != item) {
                list.add(item);
                search(adj, item, cur, list);
                break;
            }
        }
    }
}