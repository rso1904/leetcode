class Solution {
    public int reductionOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        
        for(int i=0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        while(list.size() > 0) {
            map.put(list.get(0), list.size() - 1);
            list.remove(0);
        }

        for(int i=0; i < nums.length; i++) {
            res += map.get(nums[i]);
        }
        
        return res;
    }
}