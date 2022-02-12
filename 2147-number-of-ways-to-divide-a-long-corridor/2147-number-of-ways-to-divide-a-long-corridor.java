class Solution {
    public int numberOfWays(String corridor) {
        int c = 0;
        int p = 0;
        List<Integer> plant = new ArrayList<>();
        long mod = (long)1e9 + 7;
        long res = 1;
        boolean check = true;
        boolean enter = false;
        boolean[] visited = new boolean[corridor.length()];
        
        for(int i=0; i < corridor.length(); i++) {
            if(corridor.charAt(i) == 'S') {
                check = true;
                c++;
            }
            
            if(check) {
                visited[i] = true;;
            }
            
            if(c == 2) {
                c = 0;
                check = false;
                enter = true;
            }
        }
        
        if(c != 0 || !enter) {
            return 0;
        }
        
        c = 0;
        check = true;
        
        for(int i=corridor.length()-1; i >= 0 ; i--) {
            if(corridor.charAt(i) == 'S') {
                check = true;
                c++;
            }
            
            if(check) {
                visited[i] = true;
            }
            
            if(c == 2) {
                c = 0;
                check = false;
            }
        }
        
        if(c != 0) {
            return 0;
        }
        
        for(int i=0; i < corridor.length(); i++) {
            if(!visited[i]) {
                if(corridor.charAt(i) == 'P') {
                    p++;
                }
            } else {
                if(p != 0) {
                    plant.add(p);
                    p = 0;
                }
            }
        }
        
        for(int i=0; i < plant.size(); i++) {
            res *= (plant.get(i) + 1);
            res %= mod;
        }
        
        return (int)res;
    }
}