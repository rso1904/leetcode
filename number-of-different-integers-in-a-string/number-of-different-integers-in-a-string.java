class Solution {
    public int numDifferentIntegers(String word) {
        String temp = "";
        boolean check = false;
        Set<String> res = new HashSet<>();
        
        for(int i=0; i < word.length(); i++) {
            if(word.charAt(i) >= '0' && word.charAt(i) <= '9') {
                if(temp == "" && word.charAt(i) == '0') {
                    check = true;
                    continue;
                }
                
                temp += String.valueOf(word.charAt(i));
            } else {
                if(temp != "" && !res.contains(temp)) {
                    res.add(temp);
                }
                
                if(temp == "" && check) {
                    res.add("0");
                }
                
                check = false;
                temp = "";
            }
        }
        
        if(temp != "" && !res.contains(temp)) {
            res.add(temp);
        }
        
        if(temp == "" && check) {
            res.add("0");
        }
        
        return res.size();
    }
}