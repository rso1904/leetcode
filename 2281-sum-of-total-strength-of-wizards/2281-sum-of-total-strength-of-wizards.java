class Solution {
    public int totalStrength(int[] strength) {
        long mod = (long)1e9 + 7;
        long res = 0;
        
        Stack<Integer> stack = new Stack<>();
        long[] prefix = new long[strength.length];
        long[] pprefix = new long[strength.length];
        int[] left = new int[strength.length];
        int[] right = new int[strength.length];
        
  //      Arrays.fill(left, -1);
  //      Arrays.fill(right, strength.length);
        
        for(int i=0; i < strength.length; i++) {
            prefix[i] = i == 0 ? strength[i] % mod : (prefix[i-1] + strength[i]) % mod;
            prefix[i] %= mod;
        }
        
        for(int i=0; i < prefix.length; i++) {
            pprefix[i] = i == 0 ? prefix[i] % mod : (pprefix[i-1] + prefix[i]) % mod;
            pprefix[i] %= mod;
        }
        
        for(int i=0; i < strength.length; i++) {
            while(!stack.isEmpty() && strength[stack.peek()] >= strength[i]) {
                stack.pop();
            }
            
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            
            stack.push(i);
        }
        
        stack.clear();
        
        for(int i=strength.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && strength[stack.peek()] > strength[i]) {
                stack.pop();
            }
            
            right[i] = stack.isEmpty() ? strength.length : stack.peek();
            
            stack.push(i);
        }
        
        for(int i=0; i < strength.length; i++) {
            
            long leftValue = (i - 1 < 0 ? 0 : pprefix[i - 1]) - (left[i] - 1 < 0 ? 0L : pprefix[left[i] - 1]);
            long rightValue = (right[i] >= strength.length ? pprefix[pprefix.length-1] : (right[i] - 1 < 0 ? 0L : pprefix[right[i] - 1])) - (i - 1 < 0 ? 0L : pprefix[i - 1]);
            long leftSize = right[i] - i;
            long rightSize = i - left[i];

            res = (res + strength[i] * (rightValue * rightSize % mod - leftValue * leftSize % mod)) % mod;
        }
        
        return (int) ((res + mod) % mod);
    }
}