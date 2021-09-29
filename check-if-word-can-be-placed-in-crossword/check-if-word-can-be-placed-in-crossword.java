class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i=0; i < board.length; i++) {
            for(int j=0; j < board[i].length; j++) {
                if(!visited[i][j]) {
                    int row = i;
                    int index = 0;
                    int count = 0;

                    while(row < board.length && board[row][j] != '#') {
                        visited[row][j] = true;
                        count++;
                     //   System.out.println(row + " : " + j);
                        if(index < word.length() && (board[row][j] == ' ' || board[row][j] == word.charAt(index))) {
                            index++;
                        }
                        
                        if((index == word.length() && count == index) && (row+1 >= board.length || board[row+1][j] == '#')) {
                        //    System.out.println("1");
                            return true;
                        }

                        row++;
                    }
                }
            }
        }
        
        visited = new boolean[board.length][board[0].length];
        
        for(int i=0; i < board.length; i++) {
            for(int j=0; j < board[i].length; j++) {
                if(!visited[i][j]) {
                    int col = j;
                    int index = 0;
                    int count = 0;


                    while(col < board[i].length && board[i][col] != '#') {
                        visited[i][col] = true;
                        count++;
                        
                        if(index < word.length() && (board[i][col] == ' ' || board[i][col] == word.charAt(index))) {
                            index++;
                        }
                        
                        if((index == word.length() && count == index) && (col+1 >= board[i].length || board[i][col+1] == '#')) {
                         //   System.out.println("2");
                            return true;
                        }

                        col++;
                    }
                }
            }
        }
        
        visited = new boolean[board.length][board[0].length];
        
        for(int i=board.length-1; i >= 0; i--) {
            for(int j=board[i].length-1; j >= 0; j--) {
                if(!visited[i][j]) {
                    int row = i;
                    int index = 0;
                    int count = 0;

                    while(row >= 0 && board[row][j] != '#') {
                        visited[row][j] = true;
                        count++;
                        
                        if(index < word.length() && (board[row][j] == ' ' || board[row][j] == word.charAt(index))) {
                            index++;
                        }
                        
                        if((index == word.length() && count == index) && (row-1 < 0 || board[row-1][j] == '#')) {
                       //     System.out.println("3");
                            return true;
                        }

                        row--;
                    }
                }
            }
        }
        
        visited = new boolean[board.length][board[0].length];
        
        for(int i=board.length-1; i >= 0; i--) {
            for(int j=board[i].length-1; j >= 0; j--) {
                if(!visited[i][j]) {
                    int col = j;
                    int index = 0;
                    int count = 0;

                    while(col >= 0 && board[i][col] != '#') {
                        visited[i][col] = true;
                        count++;
                        
                        if(index < word.length() && (board[i][col] == ' ' || board[i][col] == word.charAt(index))) {
                            index++;
                        }
                        
                        if((index == word.length() && count == index) && (col-1 < 0 || board[i][col-1] == '#')) {
                         //   System.out.println("4");
                            return true;
                        }

                        col--;
                    }
                }
            }
        }
        
        return false;
    }
}