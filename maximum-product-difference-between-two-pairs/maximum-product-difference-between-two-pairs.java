class Solution {
    public int maxProductDifference(int[] nums) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((a ,b) -> b - a);
        
        for(int i=0; i < nums.length; i++) {
            min.offer(nums[i]);
            max.offer(nums[i]);
        }
        
        int maxValue = 0;
        int minValue = 0;
        
        for(int i=0; i < 2; i++) {
            if(i == 0) {
                maxValue = max.poll();
                minValue = min.poll();
            } else {
                maxValue *= max.poll();
                minValue *= min.poll();
            }
        }
        
        return maxValue - minValue;
    }
}