class Solution {
    public int maximumGroups(int[] grades) {        
        int size = 0;
        int res = 0;
        int sum = 2;
        
        for(int i=0; i < grades.length; i++) {
            if(i == size) {
                res++;
                size += sum;
                sum++;
            }
        }
        
        return res;
    }
}