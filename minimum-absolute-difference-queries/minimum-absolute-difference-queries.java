class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        int[][] prefix = new int[nums.length+1][101];
        int[] count = new int[101];
        
        for(int i=1; i <= nums.length; i++) {
            count[nums[i-1]]++;
            
            for(int j=0; j < 101; j++) {
                prefix[i][j] = count[j];
            }
        }
        
        for(int i=0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int[] cnt = new int[101];
            int min = Integer.MAX_VALUE;
            int prev = -1;
            
            for(int j=0; j < 101; j++) {
                cnt[j] = prefix[right+1][j] - prefix[left][j];
            }
            
            for(int j=0; j < 101; j++) {
                if(prev == -1 && cnt[j] > 0) {
                    prev = j;
                } else if(cnt[j] > 0 && j - prev < min) {
                    min = j - prev;
                    prev = j;
                } else if(cnt[j] > 0) {
                    prev = j;
                }
            }
            
            res[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        
        return res;
    }
}