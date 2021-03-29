class Solution {
    public int countPairs(int[] nums, int low, int high) {
        int res = 0;
        
        TrieNode root = new TrieNode();
        
        for(int num : nums) {
            res += count(root, num, high+1) - count(root, num, low);
            insert(root, num);
        }
        
        return res;
    }
    
    private int count(TrieNode root, int num, int max) {
        int res = 0;
        
        for(int i=14; i >= 0 && root != null; i--) {
            int x = (num >> i) & 1;
            int y = (max >> i) & 1;
            
            if(y == 1) {
                if(root.child[x] != null)
                    res += root.child[x].count;
                
                root = root.child[1-x];
            } else {
                root = root.child[x];
            }
        }
        
        return res;
    }
    
    private void insert(TrieNode root, int num) {
        for(int i=14; i >= 0; i--) {
            int x = (num >> i) & 1;
            
            if(root.child[x] == null)
                root.child[x] = new TrieNode();
            
            root.child[x].count++;
            root = root.child[x];
        }
    }
}

class TrieNode {
    TrieNode[] child;
    int count;
    
    public TrieNode() {
        child = new TrieNode[2];
        count = 0;
    }
}