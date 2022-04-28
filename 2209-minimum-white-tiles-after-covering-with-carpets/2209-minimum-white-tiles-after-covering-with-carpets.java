class Solution {
    int[][] mem;
    
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        if(numCarpets * carpetLen >= floor.length()) {
            return 0;
        }
        
        mem = new int[floor.length()][numCarpets+1];
        int white = 0;
        
        for(int i=0; i < floor.length(); i++) {
            if(floor.charAt(i) == '1') {
                white++;
            }
        }
        
        if(carpetLen == 1) {
            return Math.max(0, white - numCarpets);
        }
        
        if(white == floor.length()) {
            return Math.max(0, white - numCarpets * carpetLen); 
        }
                
        return white - search(floor, 0, numCarpets, carpetLen);
    }
    
    private int search(String floor, int cur, int num, int len) {
        if(cur >= floor.length() || num == 0) {
            return 0;
        }
        
        
        if(mem[cur][num] != 0) {
            return mem[cur][num];
        }
        
        int res = 0;
        int count = 0;
        
        for(int i=cur; i < Math.min(cur + len - 1, floor.length()); i++) {
            if(floor.charAt(i) == '1') {
                count++;
            }
        }
        
        for(int i=cur; i < floor.length(); i++) {            
            if((i + len - 1) < floor.length() && floor.charAt(i + len - 1) == '1') {
                count++;
            }
            
            res = Math.max(res, search(floor, i + len, num-1, len) + count);
            
            if(floor.charAt(i) == '1')
                count--;
        }
   //     System.out.println(cur + " : " + num + " : " +res);
        mem[cur][num] = res;
        
        return res;
    }
}