class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] gap = new int[capacity.length];
        
        for(int i=0; i < gap.length; i++) {
            gap[i] = capacity[i] - rocks[i];
        }
        
        Arrays.sort(gap);
        
        for(int i=0; i < gap.length; i++) {
            if(additionalRocks >= gap[i]) {
                additionalRocks -= gap[i];
            } else {
                return i;
            }
        }
        
        return gap.length;
    }
}