class Solution {
    public int countLatticePoints(int[][] circles) {
        Set<String> set = new HashSet<>();
        
        for(int i=0; i < circles.length; i++) {
            int x = circles[i][0];
            int y = circles[i][1];
            int r = circles[i][2];
            
            set.add(x + " : " + y);
            
            for(int j=r; j >= 0; j--) {
                int col = (int)Math.pow(Math.pow(r, 2) - Math.pow(j, 2), 0.5);
              //  System.out.println(j + " : " + col);
                set.add((x + j) + " : " + (y + col));
                set.add((x + j) + " : " + (y - col));
                set.add((x - j) + " : " + (y + col));
                set.add((x - j) + " : " + (y - col));
                
                for(int k=col-1; k >= 0; k--) {
                    set.add((x + j) + " : " + (y + k));
                    set.add((x + j) + " : " + (y - k));
                    set.add((x - j) + " : " + (y + k));
                    set.add((x - j) + " : " + (y - k));
                }
            }
        }
        
  //      for(String key : set) {
  //          System.out.println(key);
  //      }
        
        return set.size();
    }
}