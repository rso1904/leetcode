class Solution {
    int[] root;
    int[] count;
    
    public int[] groupStrings(String[] words) {
        root = new int[words.length];
        count = new int[words.length];
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        int size = 0;
        
        for(int i=0; i < root.length; i++) {
            root[i] = i;
            count[i] = 1;
        }
        
        for(int i=0; i < words.length; i++) {
            int value = 0;
            
            for(int j=0; j < words[i].length(); j++) {
                value += 1 << (words[i].charAt(j) - 'a');
            }
            
            list.add(value);
            map.put(value, i);
        }
        
        for(int i=0; i < words.length; i++) {
            int value = list.get(i);
            
            for(int j=0; j < 26; j++) {
                if((value >> j & 1) == 1) {
                    if(map.get(value ^ 1 << j) != null) {
                        max = Math.max(max, union(i, map.get(value ^ 1 << j)));
                    }
                    
                    for(int k=0; k < 26; k++) {
                        if(j != k && (value >> k & 1) == 1) {
                            continue;
                        }
                        
                        int comp = value ^ 1 << j;
                        comp = comp ^ 1 << k;
                        
                        if(map.get(comp) != null) {
                            max = Math.max(max, union(i, map.get(comp)));
                        }
                    }
                }  
                
                if((value >> j & 1) == 0) {
                    if(map.get(value ^ 1 << j) != null) {
                        max = Math.max(max, union(i, map.get(value ^ 1 << j)));
                    }
                }
            }
        }
        
        for(int i=0; i < root.length; i++) {
            if(root[i] == i) {
                size++;
            }
        }
        
        return new int[]{size, max};
    }
    
    private int find(int x) {
        if(root[x] == x) {
            return x;
        } else {
            return root[x] = find(root[x]);
        }
    }
    
    private int union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if(x != y) {
            root[y] = x;
            count[x] += count[y];
            count[y] = 1;
        }
        
        return count[x];
    }
}