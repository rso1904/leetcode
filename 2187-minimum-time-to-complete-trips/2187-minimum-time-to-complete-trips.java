class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        
        long left = 0;
        long right = (long)time[0] * (long)totalTrips;
        
        while(left < right) {
            long mid = left + (right - left) / 2;
            long value = 0;
            
            for(int i=0; i < time.length; i++) {
                value += mid / time[i];   
            }
            
            if(totalTrips <= value) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}