class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Integer> stack = new Stack<>();
        int[][] cars = new int[position.length][2];
        int res = position.length;
        double[] time = new double[cars.length];
        
        for(int i=0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        
        Arrays.sort(cars, (a,b) -> a[0] - b[0]);
        
        for(int i=cars.length-1; i >= 0; i--) {
            time[i] = -1;
            int pos = cars[i][0];
            int speed1 = cars[i][1];
            
            while(!stack.isEmpty()) {
                int j = stack.peek();
                int afterPos = cars[j][0];
                int afterSpeed = cars[j][1];
                
                if(speed1 <= afterSpeed || 1.0 * (afterPos - pos) / (speed1 - afterSpeed) >= time[j] && time[j] >= 0) {
                    stack.pop();
                } else {
                    break;
                }
            }
            
            if(stack.size() > 0) {
                int j = stack.peek();
                int afterPos = cars[j][0];
                int afterSpeed = cars[j][1];
                
                time[i] = 1.0 * (afterPos - pos) / (speed1 - afterSpeed);
                
                if(time[i] * speed1 + pos <= target)
                    res--;
            }
            
            stack.add(i);
        }
        
        return res;
    }
}