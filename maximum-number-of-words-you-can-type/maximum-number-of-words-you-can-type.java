class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        boolean check = false;
        
        for(int i=0; i < brokenLetters.length(); i++) {
            set.add(brokenLetters.charAt(i));
        }
        
        for(int i=0; i < text.length(); i++) {
            if(text.charAt(i) == ' ') {
                if(!check) {
                    res++;
                } else {
                    check = false;
                }
            } else if(set.contains(text.charAt(i))) {
                check = true;
            }
        }
        
        if(!check)
            res++;
        
        return res;
    }
}