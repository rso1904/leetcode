class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int res = friendships.length;
        Map<Integer, Set<Integer>> lang = new HashMap<>();
        
        for(int i=0; i < languages.length; i++) {
            for(int j=0; j < languages[i].length; j++) {
                if(lang.get(i+1) == null) {
                    lang.put(i+1, new HashSet<>());
                }
                
                lang.get(i+1).add(languages[i][j]);
            }
        }
        
        for(int i=1; i <= n; i++) {
            Set<Integer> teach = new HashSet<>();
        //    int count = 0;
            
            for(int j=0; j < friendships.length; j++) {
                boolean check = false;
                
                for(Integer item : lang.get(friendships[j][0])) {
                    if(lang.get(friendships[j][1]).contains(item)) {
                        check = true;
                        break;
                    }
                }
                
                if(check) {
                   continue; 
                }
                
             //   count++;
                
                if(!lang.get(friendships[j][0]).contains(i)) {
                    teach.add(friendships[j][0]);
                }
                
                if(!lang.get(friendships[j][1]).contains(i)) {
                    teach.add(friendships[j][1]);
                }
            }
        //    res = Math.min(res, count);
            res = Math.min(res, teach.size());
        }
        
        return res;
    }
}