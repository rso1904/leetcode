class Solution {
    public String longestNiceSubstring(String s) {
        boolean[] low = new boolean[26];
        boolean[] upper = new boolean[26];
        int max = 0;
        List<String> list = new ArrayList<>();
        
        for(int i=0; i < s.length(); i++) {
            for(int j=i+1; j <= s.length(); j++) {
                String item = s.substring(i, j);
                low = new boolean[26];
                upper = new boolean[26];
                
                for(int k=0; k < item.length(); k++) {
                   if(item.charAt(k) >= 'a' && item.charAt(k) <= 'z') {
                        low[item.charAt(k) - 'a'] = true;
                    } else {
                        upper[item.charAt(k) - 'A'] = true;
                    }
                }
                
                    
                for(int k=0; k < item.length(); k++) {
                    if(item.charAt(k) >= 'a' && item.charAt(k) <= 'z') {
                        if(!upper[item.charAt(k) - 'a'])
                            break;
                    } else {
                        if(!low[item.charAt(k) - 'A'])
                            break;
                    }
                    
                    if(k == item.length() - 1) {
                        list.add(item);
                        max = Math.max(max, j-i);
                    }
                }
            }
        }
        
        for(String res : list) {
            if(res.length() == max)
                return res;
        }
        
        return "";
    }
}