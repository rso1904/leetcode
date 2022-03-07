class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        stack.push(nums[0]);
        
        for(int i=1; i < nums.length; i++) {
            int prev = stack.peek();
            int cur = nums[i];
            int gcd = gcd(prev, cur);
            
            while(gcd > 1) {
                cur = lcm(prev, cur, gcd);
                
                stack.pop();
                
                if(stack.isEmpty())
                    break;
                
                prev = stack.peek();
                gcd = gcd(prev, cur);
            }
            
            stack.push(cur);
        }
        
        while(!stack.isEmpty()) {
            res.add(stack.pop());
        }
        
        Collections.reverse(res);
                
        return res;
    }
    
    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
    
    private int lcm(int a, int b, int gcd) {
        long lcm = ((long)a * (long)b) / (long) gcd;
        return (int)lcm;
    }
}