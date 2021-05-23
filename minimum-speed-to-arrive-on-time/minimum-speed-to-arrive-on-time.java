class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if(dist.length - 1 > (int)hour)
            return -1;
        
        int res = lower(dist, hour);
                
        return res == 1_000_000_000 ? -1 : res;
    }
    
    private int lower(int[] dist, double target) {
        int left = 1;
        int right = 1_000_000_000;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            double time = 0;
            double speed = (double) mid;
            
            for(int j=0; j < dist.length; j++) {
                if(dist[j] <= speed) {
                    if(j == dist.length-1) {
                        time = time + ((double)dist[j] / speed);
                    } else {
                        time += 1;
                    }
                } else {
                    if(j == dist.length-1) {
                        time = time + ((double)dist[j] / speed);
                    } else {
                        time = time + Math.ceil(((double)dist[j] / speed));
                    }
                }
            }
      //      System.out.println(target + " : " + time + " : " + speed + " : " + mid);
            if(target < time) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}