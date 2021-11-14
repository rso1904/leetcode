class Solution {
    Map<String, Boolean> mem = new HashMap<>();

    public boolean possiblyEquals(String s1, String s2) {        
        return search(s1, s2, 0, 0, 0, 0);
    }
    
    private boolean search(String s1, String s2, int index1, int index2, int count1, int count2) {
        if(s1.length() <= index1 && s2.length() <= index2) {
            if(count1 == count2)
                return true;
            else
                return false;
        }
        
        if(index1 >= s1.length() && count1 <= 0) {
            return false;
        }
        
        if(index2 >= s2.length() && count2 <= 0) {
            return false;
        }
        
        String key = index1 + ":" + index2 + ":" + count1 + ":" + count2;
        if(mem.containsKey(key)) {
            return mem.get(key);
        }
        
        boolean res = false;
        
        if(count1 > 0 && count2 > 0) {
            if(count1 == count2) {
                res = search(s1, s2, index1, index2, 0, 0);      
            } else if(count1 > count2) {
                res = search(s1, s2, index1, index2, count1 - count2, 0);
            } else {
                res = search(s1, s2, index1, index2, 0, count2 - count1);
            }
        } else if(index1 < s1.length() && Character.isDigit(s1.charAt(index1))) {
            res = search(s1, s2, index1+1, index2, count1 + (s1.charAt(index1) - '0'), count2);
            
            if(index1+1 < s1.length() && Character.isDigit(s1.charAt(index1+1))) {
                String value =  "" + s1.charAt(index1) + s1.charAt(index1+1);
                res = res == false ? search(s1,s2, index1+2, index2, count1 + Integer.parseInt(value), count2) : res;
                
                if(index1+2 < s1.length() && Character.isDigit(s1.charAt(index1+2))) {
                    value =  "" + s1.charAt(index1) + s1.charAt(index1+1) + s1.charAt(index1+2);
                    res = res == false ? search(s1,s2, index1+3, index2, count1 + Integer.parseInt(value), count2) : res;
                }
            }
        } else if(index2 < s2.length() && Character.isDigit(s2.charAt(index2))) {
            res = search(s1, s2, index1, index2+1, count1, count2 + (s2.charAt(index2) - '0'));
            
            if(index2+1 < s2.length() && Character.isDigit(s2.charAt(index2+1))) {
                String value = "" + s2.charAt(index2) + s2.charAt(index2+1);
                res = res == false ? search(s1,s2, index1, index2+2, count1, count2 + Integer.parseInt(value)) : res;
                
                if(index2+2 < s2.length() && Character.isDigit(s2.charAt(index2+2))) {
                    value =  "" + s2.charAt(index2) + s2.charAt(index2+1) + s2.charAt(index2+2);
                    res = res == false ? search(s1,s2, index1, index2+3, count1, count2 + Integer.parseInt(value)) : res;
                }
            }
        } else {
            if(count1 > 0) {
                res = search(s1, s2, index1, index2+1, count1-1, count2);
            } else if(count2 > 0) {
                res = search(s1, s2, index1+1, index2, count1, count2-1);
            } else {
                if(s1.charAt(index1) == s2.charAt(index2)) {
                    res = search(s1, s2, index1+1, index2+1, count1, count2);
                } else {
                    res = false;
                }
            }
        }
        
        mem.put(key, res);
        return res;
    }
}