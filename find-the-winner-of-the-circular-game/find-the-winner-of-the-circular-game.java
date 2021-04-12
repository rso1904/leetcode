class Solution {
    public int findTheWinner(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int index = k - 1;
        
        for(int i=1; i <= n; i++) {
            list.add(i);
        }
        
        while(list.size() > 1) {
            list.remove(index);
            
            index = (index - 1 + k) % list.size();
        }
        
        return list.get(0);
    }
}