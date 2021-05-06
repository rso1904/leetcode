class Solution {
    public int getMinSwaps(String num, int k) {
        int[] nums = new int[num.length()];
        int[] ori = new int[num.length()];
        int res = 0;
        
        for(int i=0; i < num.length(); i++) {
            nums[i] = num.charAt(i) - '0';
            ori[i] = num.charAt(i) - '0';
        }
        
        for(int i=0; i < k; i++) {
            nextPermutation(nums);
        }
        
        int i = ori.length-1;
        int j = 0;
        
        while(i >= 0) {
            j = i;
            
            while(ori[i] != nums[j]) {
                j--;
            }
            
            while(j < i) {
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
                j++;
                res++;
            }
            
            i--;
        }
        
        return res;
    }
    
    public void nextPermutation(int[] nums) {   
        int changeIndex = -1;
        int changedIndex = -1;
        
        for(int i=nums.length - 1; i >= 1; i--) {
            if(nums[i-1] < nums[i]) {
                changeIndex = i-1;
                break;
            } 
        }
        
        if(changeIndex == -1) {
            reverse(nums, 0, nums.length-1);
        } else {
            for(int i=nums.length - 1; i > changeIndex; i--) {
                if(nums[changeIndex] < nums[i]) {
                    changedIndex = i;
                    break;
                }
            }
            
            swap(nums, changeIndex, changedIndex);
            reverse(nums, changeIndex+1, nums.length-1);
        }
    }
    
    private void reverse(int[] nums, int s, int e){
      while(s < e){
        swap(nums, s, e);
        s++;
        e--;
      }
    }
    
    private void swap(int[] nums, int s, int e){
        int t = nums[s];
        nums[s] = nums[e];
        nums[e] = t;     
    }
}