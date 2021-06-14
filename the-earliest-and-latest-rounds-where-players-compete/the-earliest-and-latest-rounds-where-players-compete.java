class Solution {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int[] num = new int[n+1];
        
        for(int i=1; i <= n; i++) {
            num[i] = 1;
        }
        
        search(num, 1, firstPlayer, secondPlayer, 1, n, n);
        
        return new int[]{min, max};
    }
    
    private void search(int[] num, int round, int first, int second, int left, int right, int n) {
        if(left >= right) {
            search(num, round+1, first, second, 1, n, n);
        } else if(num[left] == 0) {
            search(num, round, first, second, left+1, right, n);
        } else if(num[right] == 0) {
            search(num, round, first, second, left, right-1, n);
        } else if(left == first && right == second) {
            min = Math.min(min, round);
            max = Math.max(max, round);
        } else {
            if(left != first && left != second) {
                num[left] = 0;
                search(num, round, first, second, left+1, right-1, n);
                num[left] = 1;
            }
            
            if(right != first && right != second) {
                num[right] = 0;
                search(num, round, first, second, left+1, right-1, n);
                num[right] = 1;
            }
        }
    }
}