class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor = 0;
        int xor1 = 0;
        
        for(int i=0; i < arr1.length; i++) {
            xor ^= arr1[i];
        }
        
        for(int i=0; i < arr2.length; i++) {
            xor1 ^= arr2[i];
        }
        
        return xor & xor1;
    }
}