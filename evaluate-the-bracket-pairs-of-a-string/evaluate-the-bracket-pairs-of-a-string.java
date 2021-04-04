class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        boolean left = false;
        StringBuilder res = new StringBuilder();
        StringBuilder value = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        
        for(int i=0; i < knowledge.size(); i++) {
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }
        
        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                left = true;
            } else if(s.charAt(i) == ')') {
                if(map.containsKey(value.toString())) {
                    String item = map.get(value.toString());
                    res.append(item);
                } else {
                    res.append("?");
                }
                left = false;
                value.setLength(0);
            } else if(!left) {
                res.append(s.charAt(i));
            } else {
                value.append(s.charAt(i));
            }
        }
        
        return res.toString();
    }
}