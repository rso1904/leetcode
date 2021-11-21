class RangeFreqQuery {
    Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
    int[] count = new int[10001];
    
    public RangeFreqQuery(int[] arr) {
        for(int i=0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], x -> new TreeMap<>()).put(i, ++count[arr[i]]);
        }
    }
    
    public int query(int left, int right, int value) {
        TreeMap<Integer, Integer> tree = map.get(value);
        
        if(tree == null)
            return 0;
        
        Integer minKey = tree.ceilingKey(left);
        Integer maxKey = tree.floorKey(right);
        
        if(maxKey == null || minKey == null)
            return 0;
        
        return tree.get(maxKey) - tree.get(minKey) + 1;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */