class Solution {
    public long numberOfWeeks(int[] milestones) {
        Arrays.sort(milestones);
        long res = milestones[milestones.length-1]-1;
        long sum = milestones[milestones.length-1];
        
        for(int i=milestones.length-2; i >= 0; i--) {
            res -= milestones[i];
            sum += milestones[i];
        }
        
        return res > 0 ? sum - res : sum;
    }
}