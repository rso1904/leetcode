    int mouseJump = 0;
    int catJump = 0;
    
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        char[][] grid1 = new char[grid.length][grid[0].length()];
        dp = new int[grid.length * grid[0].length() * 2][grid.length][grid[0].length()][grid.length][grid[0].length()];
        this.mouseJump = mouseJump;
        this.catJump = catJump;
        int[] mouse = new int[2];
        int[] cat = new int[2];
        
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length(); j++) {
                grid1[i][j] = grid[i].charAt(j);
                
                if(grid1[i][j] == 'M') {
                    mouse[0] = i;
                    mouse[1] = j;
                } else if(grid1[i][j] == 'C') {
                    cat[0] = i;
                    cat[1] = j;
                }
            }
        }
        
        return search(grid1, mouse, cat, 0);
    }
    
    private boolean search(char[][] grid, int[] mouse, int[] cat, int mode) {
        if(mode >= grid.length * grid[0].length * 2)
            return false;
        
        if(dp[mode][mouse[0]][mouse[1]][cat[0]][cat[1]] != 0)
            return dp[mode][mouse[0]][mouse[1]][cat[0]][cat[1]] == 1 ? true : false;
        
        if(mode % 2 == 0) {
            for(int i=0; i < dir.length; i++) {
                for(int j=0; j <= mouseJump; j++) {
                    int x = mouse[0] + dir[i][0] * j;
                    int y = mouse[1] + dir[i][1] * j;
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != '#') {
                        if(grid[x][y] == 'F' || search(grid, new int[]{x,y}, cat, mode+1)) {
                            dp[mode][mouse[0]][mouse[1]][cat[0]][cat[1]] = 1;
                            return true;
                        }
                    } else {
                        break;
                    }
                }
            }
            dp[mode][mouse[0]][mouse[1]][cat[0]][cat[1]] = 2;
            return false;
        } else {
            for(int i=0; i < dir.length; i++) {
                for(int j=0; j <= catJump; j++) {
                    int x = cat[0] + dir[i][0] * j;
                    int y = cat[1] + dir[i][1] * j;
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != '#') {
                        if(grid[x][y] == 'F' || (x == mouse[0] && y == mouse[1]) || !search(grid, mouse, new int[]{x,y}, mode+1)) {
                            dp[mode][mouse[0]][mouse[1]][cat[0]][cat[1]] = 2;
                            return false;
                        } 
                    } else {
                        break;
                    }
                }
            }
            dp[mode][mouse[0]][mouse[1]][cat[0]][cat[1]] = 1;
            return true;
        }
    }
}
