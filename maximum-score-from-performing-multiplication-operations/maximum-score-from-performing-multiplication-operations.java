class Solution {
    int res = 0;
    int[][] mem;
    
    public int maximumScore(int[] nums, int[] multipliers) {
        mem = new int[multipliers.length][multipliers.length];
        return search(nums, multipliers, 0, nums.length-1, 0);
    }
    
    private int search(int[] nums, int[] multipliers, int start, int end, int j) {
        if(j >= multipliers.length) {
            return 0;
        }
        
        if(mem[start][j] != 0) {
            return mem[start][j];
        }
        
        int value = 0;
        value = nums[start] * multipliers[j] + search(nums, multipliers, start+1, end, j+1);
        value = Math.max(value, nums[end] * multipliers[j] + search(nums, multipliers, start, end-1, j+1));
    
        mem[start][j] = value;
        
        return value;
    }
}