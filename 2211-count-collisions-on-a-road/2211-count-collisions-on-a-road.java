class Solution {
    public int countCollisions(String directions) {
        char[] c = directions.toCharArray();
        int res = 0;
        Stack<Character> stack = new Stack<>();
        
        stack.push(c[0]);
 
        for(int i=1; i < c.length; i++) {
            stack.push(c[i]);
            
            while(!stack.isEmpty()) {
                char cur = stack.pop();
                
                if(stack.isEmpty()) {
                    stack.push(cur);
                    break;
                }
                
                if(stack.peek() == 'R' && cur == 'L') {
                    res += 2;
                    stack.pop();
                    stack.push('S');
                } else if(stack.peek() == 'S' && cur == 'L') {
                    res++;
                    stack.pop();
                    stack.push('S');
                } else if(stack.peek() == 'R' && cur == 'S') {
                    res++;
                    stack.pop();
                    stack.push('S');
                } else {
                    stack.push(cur);
                    break;
                }
            }
            
        }
        
        return res;
    }
}