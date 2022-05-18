class CountIntervals {
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    int count = 0;
    
    public CountIntervals() {
        
    }
    
    public void add(int left, int right) {
    //    System.out.println(left + " : " + right + " : " + count);
        while(treeMap.ceilingEntry(left) != null && treeMap.ceilingEntry(left).getValue() <= right) {
            count -= treeMap.ceilingEntry(left).getValue() - treeMap.ceilingEntry(left).getKey() + 1;
            treeMap.remove(treeMap.ceilingEntry(left).getKey());
        }
        
        
        if(treeMap.floorEntry(left) != null && treeMap.floorEntry(left).getKey() < left && treeMap.floorEntry(left).getValue() > right) {
            return;
        }
        
        if(treeMap.floorEntry(left) != null && treeMap.ceilingEntry(left) != null && treeMap.floorEntry(left).getKey() <= left && treeMap.floorEntry(left).getValue() <= right && treeMap.floorEntry(left).getValue() >= left && treeMap.ceilingEntry(left).getKey() >= left && treeMap.ceilingEntry(left).getValue() >= right && treeMap.ceilingEntry(left).getKey() <= right) {
        //    System.out.println("hi");
            int l = treeMap.floorEntry(left).getKey();
            int r = treeMap.ceilingEntry(left).getValue();
            int rE = treeMap.ceilingEntry(left).getKey();
     //       System.out.println(l + " : " + treeMap.floorEntry(left).getValue() + " : " + treeMap.ceilingEntry(left).getKey() + " : "+  r);
            count -= treeMap.floorEntry(left).getValue() - treeMap.floorEntry(left).getKey() + 1;
     //       System.out.println(count);
            count -= treeMap.ceilingEntry(left).getValue() - treeMap.ceilingEntry(left).getKey() + 1;
    //        System.out.println(count);
            count += r - l + 1;
            treeMap.put(l, r);
            treeMap.remove(rE);
        } else if(treeMap.ceilingEntry(left) != null && treeMap.ceilingEntry(left).getKey() <= right && treeMap.ceilingEntry(left).getKey() >= left) {
            count += treeMap.ceilingEntry(left).getKey() - left;
            int r = treeMap.ceilingEntry(left).getKey();
            treeMap.put(left, treeMap.ceilingEntry(left).getValue());
            treeMap.remove(r);
        } else if(treeMap.floorEntry(left) != null && treeMap.floorEntry(left).getKey() <= left && treeMap.floorEntry(left).getValue() <= right && treeMap.floorEntry(left).getValue() >= left) {
            count += right - treeMap.floorEntry(left).getValue();
            treeMap.put(treeMap.floorEntry(left).getKey(), right);
        } else {
            count += right - left + 1;
            treeMap.put(left, right);
        }
  //      System.out.println(left + " : " + right + " : " + count);
    }
    
    public int count() {
        return count;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */