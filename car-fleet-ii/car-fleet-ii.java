class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        double[] res = new double[cars.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=cars.length-1; i >= 0; i--) {
            res[i] = -1.0;
            int pos = cars[i][0];
            int speed = cars[i][1];
            
            while(!stack.isEmpty()) {
                int j = stack.peek();
                int afterPos = cars[j][0];
                int afterSpeed = cars[j][1];
                
                if(speed <= afterSpeed || 1.0 * (afterPos - pos) / (speed - afterSpeed) >= res[j] && res[j] >= 0) {
                    stack.pop();
                } else {
                    break;
                }
            }
            
            if(stack.size() > 0 ) {
                int j = stack.peek();
                int afterPos = cars[j][0];
                int afterSpeed = cars[j][1];
                
                res[i] = 1.0  * (afterPos - pos) / (speed - afterSpeed);
            }
            
            stack.push(i);
        }
        
        return res;
    }
}