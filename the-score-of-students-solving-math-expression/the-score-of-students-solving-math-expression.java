class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        int n = s.length() / 2 + 1;
        Set<Integer>[][] dp = new Set[n][n];
        
        for(int i=0; i < n; i++) {
            dp[i][i] = new HashSet<>();
            dp[i][i].add(s.charAt(2 * i) - '0');
        }
        
        for(int diff=1; diff < n; diff++) {
            for(int start=0; start < n - diff; start++) {
                int end = start + diff;
                dp[start][end] = new HashSet<>();
                
                for(int i=start * 2 + 1; i < end * 2; i += 2) {
                    if(s.charAt(i) == '+') {
                        for(int a : dp[start][i / 2]) {
                            for(int b : dp[i / 2 + 1][end]) {
                                if(a + b <= 1000)
                                    dp[start][end].add(a + b);
                            }
                        }
                    } else {
                        for(int a : dp[start][i / 2]) {
                            for(int b : dp[i / 2 + 1][end]) {
                                if(a * b <= 1000)
                                    dp[start][end].add(a * b);
                            }
                        }
                    }
                }
            }
        }
        
        int res = 0;
        int correct = getCorrect(s);
        
        for(int item : answers) {
            if(item == correct) res += 5;
            else if(dp[0][n-1].contains(item)) res += 2;
        }
        
        return res;
    }
    
    private int getCorrect(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean check = false;
        
        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) == '*') {
                check = true;
            } else if(check) {
                check = false;
                Integer op = Character.getNumericValue(s.charAt(i));
                Integer op1 = stack.pop();
                Integer res = op * op1;
                stack.push(res);
            } else if(s.charAt(i) == '+') {
                
            } else {
                check = false;
                stack.push(Character.getNumericValue(s.charAt(i)));
            }
        }
        
        while(stack.size() > 1) {
            Integer op1 = stack.pop();
            Integer op2 = stack.pop();
            Integer res = op1 + op2;
            stack.push(res);
        }
        
        return stack.pop();
    }
}