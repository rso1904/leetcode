class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        TreeMap<Integer, Integer> start = new TreeMap<>();
        TreeMap<Integer, Integer> end = new TreeMap<>();
        int[] res = new int[persons.length];
        
        Arrays.sort(flowers, (a, b) -> a[0] - b[0]);
        
        for(int i=0; i < flowers.length; i++) {
            int index = start.floorKey(flowers[i][0]) == null ? -1 : start.floorKey(flowers[i][0]);
            
            if(index == -1) {
                start.put(flowers[i][0], 1);
            } else {
                start.put(flowers[i][0], start.get(index) + 1);
            }
        }
        
        Arrays.sort(flowers, (a, b) -> a[1] - b[1]);
        
        for(int i=0; i < flowers.length; i++) {
            int index = end.floorKey(flowers[i][1]+1) == null ? -1 : end.floorKey(flowers[i][1]
+1);
            
            if(index == -1) {
                end.put(flowers[i][1]+1, -1);
            } else {
                end.put(flowers[i][1]+1, end.get(index) - 1);
            }
        }
        
        for(int i=0; i < persons.length; i++) {
            Integer s = start.floorKey(persons[i]);
            Integer e = end.floorKey(persons[i]);
            
            Integer sv = s == null ? 0 : start.get(s);
            Integer ev = e == null ? 0 : end.get(e);
      //      System.out.println(s + " : " + e + " : " + sv + " : " + ev);
            res[i] = sv + ev;
        }
        
        return res;
    }
}