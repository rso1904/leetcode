class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        Stack<Character> stack = new Stack<Character>();
        int[] count = new int[26];
        
        for(int i=0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        for(int i=0; i < s.length(); i++) {            
          //  System.out.println((s.length() - i) + " : " + k);
            while(!stack.isEmpty() && s.charAt(i) < stack.peek() && (s.length() - i - 1) >= k) {
                if(stack.peek() == letter) {
                    if(count[letter - 'a'] <= repetition) {
                        break;
                    } else {
                        stack.pop();
                        repetition++;
                        k++;
                    }
                } else {
                    stack.pop();
                    k++;
                }
            }
            

            while(k < repetition) {
                stack.pop();
                k++;
            }

            
            if(k > 0) {
                stack.push(s.charAt(i));
                k--;
                repetition = s.charAt(i) == letter ? repetition - 1 : repetition;
            }
            count[s.charAt(i) - 'a']--;
        }
        
        String res = "";
        
        while(!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        
        return res;
    }
}