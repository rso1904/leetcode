class Solution {
    public int minMovesToMakePalindrome(String s) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = s.length() - 1;
        int count = 0;
        char[] c = s.toCharArray();
        
        while(left < right) {
            if(c[left] != c[right]) {
                int index = right;
                
                while(c[index] != c[left]) {
                    index--;
                }
                
                if(index == left) {                 
                    char temp = c[index];
                    c[index] = c[index+1];
                    c[index+1] = temp;
                    count++;
                } else {
                    while(index < right) {
                        char temp = c[index];
                        c[index] = c[index+1];
                        c[index+1] = temp;
                        index++;
                        count++;
                    }
                    
                     left++;
                    right--;
                }
            } else {
                left++;
                right--;
            }
        }
        
        return count;
    }
}