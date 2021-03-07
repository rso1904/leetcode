class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0, diff;
        for (int a : nums)
            sum += a;
        diff = Math.abs(goal - sum);
        return (int)((diff + limit - 1) / limit);
    }
}