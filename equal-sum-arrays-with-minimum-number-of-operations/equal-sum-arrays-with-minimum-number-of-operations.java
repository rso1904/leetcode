class Solution {    
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0;
        int sum2 = 0;
        int diff = 0;
        int res = 0;
        
        for(int i=0; i < nums1.length; i++) {
            sum1 += nums1[i];
        }
        
        for(int j=0; j < nums2.length; j++) {
            sum2 += nums2[j];
        }
        
        diff = Math.abs(sum2 - sum1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        if(sum2 > sum1) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        
        int j = 0;
        int i = nums1.length-1;
        
        if(diff <= 0)
            return res;
        
        while(i >= 0 && j < nums2.length) {
            if((nums1[i] - 1) >= (6 - nums2[j])) {
                diff -= (nums1[i] - 1);
                nums1[i--] = 1;
                res++;

                if(diff <= 0)
                    break;
            } else {
                diff -= (6 - nums2[j]);
                nums2[j++] = 6;
                res++;

                if(diff <= 0)
                    break;
            }
        }
        
        if(diff <= 0)
            return res;
        
        while(i >= 0) {
            diff -= (nums1[i] - 1);
            nums1[i--] = 1;
            res++;
            
            if(diff <= 0)
                return res;
        }
        
        while(j < nums2.length) {
            diff -= (6 - nums2[j]);
            nums2[j++] = 6;
            res++;
            
            if(diff <= 0)
                return res;
        }
        
        
        return -1;
    }
}