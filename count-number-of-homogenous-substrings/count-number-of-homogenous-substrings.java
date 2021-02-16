class Solution {
    public int countHomogenous(String s) {
        int res = 0;
        List<Integer> list = new ArrayList<>();
        int count = 1;
        
        for(int i=1; i < s.length(); i++) {
            if(s.charAt(i-1) == s.charAt(i)) {
                count++;
            } else {
                list.add(count);
                count = 1;
            }
        }
        
        list.add(count);
        
        for(int i=0; i < list.size(); i++) {
            long n = (long)list.get(i);
            n = (n * (n+1)) % 1000000007;
            res += (n / 2) % 1000000007;
        }
        
        return res;
    }
}