class Solution {
    public boolean splitString(String s) {
        return search(s, new ArrayList<>());
    }
    
    private boolean search(String s, List<Long> list) {
        boolean check = false;
        
        for(int i=1; i < list.size(); i++) {
            if(list.get(i-1) < list.get(i) || list.get(i-1) - list.get(i) > 1) {
                check = true;
                break;
            }
        }
        
        if(list.size() > 0 && !check) {
            try {
                if(list.get(list.size()-1) > Long.valueOf(s) && list.get(list.size()-1) - Long.valueOf(s) == 1)
                    return true;
            } catch(Exception e) {
                
            }
        }
        
        for(int i=1; i < s.length(); i++) {
            try {
                list.add(Long.valueOf(s.substring(0, i)));
                boolean temp = search(s.substring(i, s.length()), list);
                if(temp)
                    return true;
                list.remove(list.size()-1);
            } catch(Exception e) {
                
            }
        }
        
        return false;
    }
}