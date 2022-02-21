class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        long res = 0;
        List<Integer> list = new ArrayList<>();
        int[] left = new int[nums1.length];
        int[] right = new int[nums1.length];
        int[] pos = new int[nums1.length];
        
        for(int i=0; i < nums2.length; i++) {
            pos[nums2[i]] = i;
        }
        
        for(int i=0; i < nums1.length; i++) {
            int pre = lower(list, pos[nums1[i]]);
            left[i] = pre;
            list.add(pre, pos[nums1[i]]);
        }
        
        list.clear();
        
        for(int i=nums1.length-1; i >= 0; i--) {
            int pre = lower(list, pos[nums1[i]]);
            right[i] = list.size() - pre;
            list.add(pre, pos[nums1[i]]);
        }
        
        for(int i=0; i < nums1.length; i++) {
            res += (long)left[i] * right[i];
        }
        
        return res;
    }
    
    private int lower(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            
            if(target <= list.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}