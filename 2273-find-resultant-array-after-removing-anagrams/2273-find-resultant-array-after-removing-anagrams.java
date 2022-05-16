class Solution {
    public List<String> removeAnagrams(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        
        for(int i=0; i < words.length; i++) {
            char[] temp = words[i].toCharArray();
            Arrays.sort(temp);
            String value = String.valueOf(temp);
            
            if(map.get(value) == null) {
                map.clear();
                map.put(value, i);
                res.add(words[i]);
            }
        }
        
        return res;
    }
}