class Solution {
    public long minimalKSum(int[] nums, int k) {
        long res = 0;
        long sum = 0;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i < nums.length; i++) {
            if(!set.contains(nums[i]) && nums[i] <= k) {
                k++;
                sum += nums[i];
                set.add(nums[i]);
            }
        }
        
        return (long)((long)k * (long)(k+1)) / 2 - sum;
    }
}