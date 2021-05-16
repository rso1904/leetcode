class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> count = new HashMap<>();
    
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        
        for(int i=0; i < nums2.length; i++) {
            count.put(nums2[i], count.getOrDefault(nums2[i], 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        count.put(nums2[index], count.getOrDefault(nums2[index], 0) - 1);
        
        if(count.get(nums2[index]) < 0)
            count.put(nums2[index], 0);
        
        nums2[index] += val;
        
        count.put(nums2[index], count.getOrDefault(nums2[index], 0)+1);
    }
    
    public int count(int tot) {
        int res = 0;
        
        for(int i=0; i < nums1.length; i++) {
            if(count.get(tot - nums1[i]) != null) {
                res += count.get(tot - nums1[i]);
            }
        }
        
        return res;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */