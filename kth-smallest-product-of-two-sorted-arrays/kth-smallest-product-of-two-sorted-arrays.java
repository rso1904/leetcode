class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = (long)0;
        long right = (long)1e10 + 1;
        long negativeSize = 0;
        List<Integer> A1 = new ArrayList<>(); // minus
        List<Integer> A2 = new ArrayList<>(); // plus
        List<Integer> B1 = new ArrayList<>(); // minus
        List<Integer> B2 = new ArrayList<>(); // plus
        long s = 1;
        
        for(int i=0; i < nums1.length; i++) {
            if(nums1[i] < 0) {
                A1.add(nums1[i] * -1);
            }
            
            if(nums1[i] >= 0) {
                A2.add(nums1[i]);
            }
        }
        
        for(int i=0; i < nums2.length; i++) {
            if(nums2[i] < 0) {
                B1.add(nums2[i] * -1);
            }
            
            if(nums2[i] >= 0) {
                B2.add(nums2[i]);
            }
        }
        
        Collections.sort(A1);
        Collections.sort(B1);
        
        
        negativeSize = A1.size() * B2.size() + A2.size() * B1.size();
        
        if(k > negativeSize) {
            k -= negativeSize;
            s = 1;
        } else {
            k = negativeSize - k + 1;
            List<Integer> temp = B1;
            B1 = B2;
            B2 = temp;
            s = -1;
        }
        
    
        while(left < right) {
            long mid = left + (right - left) / 2;

            if(k <= check(mid, A1, B1) + check(mid, A2, B2)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left * s;
    }
    
    private long check(long value, List<Integer> nums1, List<Integer> nums2) {
        long total = 0;
        int j = nums2.size() - 1;
        
        for(Integer n1 : nums1) {
            while(j >= 0 && (long)n1 * (long)nums2.get(j) > value) {
                j--;
            }
            
            total += j + 1;
        }
        
        return total;
    }
}