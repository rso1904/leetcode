class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        return upper(cells, row, col);
    }
    
    private int upper(int[][] cells, int row, int col) {
        int left = 0;
        int right = cells.length;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            
            if(bfs(cells, mid, row, col)) {
     //           System.out.println(mid);
                left = mid+1;
            } else {
                right = mid;
            }
            
        //    System.out.println(left + " : " + right + " : " + mid);
        }
        
        return left;
    }
    
    private boolean bfs(int[][] cells, int mid, int row, int col) {
        Set<Integer> visited = new HashSet<>();
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        for(int i=0; i <= mid; i++) {
            int cur = cells[i][0] * 100000 + cells[i][1];
            visited.add(cur);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=1; i <= col; i++) {
            int cur = 1 * 100000 + i;
            if(!visited.contains(cur)) {
                queue.offer(cur);
                visited.add(cur);
            } 
        }
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            int r = cur / 100000;
            int c = cur % 100000;
            
            if(r == row) {
                return true;
            }
            
       //     System.out.println(r + " : " + c);
            
            for(int i=0; i < 4; i++) {
                int newR = r + dir[i][0];
                int newC = c + dir[i][1];
                int newCur = newR * 100000 + newC;
                
                if(newR >= 1 && newR <= row && newC >= 1 && newC <= col && !visited.contains(newCur)) {
                    queue.offer(newCur);
                    visited.add(newCur);
                }
            }
        }
        
        return false;
    }
}