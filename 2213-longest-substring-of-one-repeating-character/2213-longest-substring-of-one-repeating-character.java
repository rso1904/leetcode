class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int[] res = new int[queryIndices.length];
        SegementTree st = new SegementTree(s);
        
        st.build(s, 0, 0, s.length()-1);
        
        for(int i=0; i < queryIndices.length; i++) {
            st.update(0, 0, s.length()-1, queryIndices[i], queryCharacters.charAt(i));
            res[i] = st.getMaxSize(0);
        } 
                
        return res;
    }
}

class SegementTree {
    
    private int[] maxSize;
    private char[] leftMost;
    private char[] rightMost;
    private int[] leftIndex;
    private int[] rightIndex;
    
    public SegementTree(String s) {
        int h = (int) Math.ceil(Math.log(s.length()) / Math.log(2));
        int treeSize = (int) Math.pow(2, h + 1) - 1;
        
        maxSize = new int[treeSize];
        leftMost = new char[treeSize];
        rightMost = new char[treeSize];
        leftIndex = new int[treeSize];
        rightIndex = new int[treeSize];
    }
    
    public int getMaxSize(int index) {
        return maxSize[index];
    }
    
    public void build(String s, int index, int start, int end) {
        if(start > end) {
            return;
        }
        
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        
        if(start == end) {
            leftMost[index] = s.charAt(start);
            rightMost[index] = s.charAt(end);
            leftIndex[index] = start;
            rightIndex[index] = start;
            maxSize[index] = 1;
            
            return;
        }
        
        int mid = start + (end - start) / 2;
        
        build(s, leftChild, start, mid);
        build(s, rightChild, mid+1, end);
        
        merge(index, start, mid, end);
    }
    
    public void merge(int index, int start, int mid, int end) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int max = 0;
        
        leftMost[index] = leftMost[leftChild];
        rightMost[index] = rightMost[rightChild];
        leftIndex[index] = leftIndex[leftChild];
        rightIndex[index] = rightIndex[rightChild];
        
        if(rightMost[leftChild] == leftMost[rightChild]) {
            if(leftIndex[leftChild] == mid) {
                leftIndex[index] = leftIndex[rightChild]; 
            }
            
            if(rightIndex[rightChild] == mid + 1) {
                rightIndex[index] = rightIndex[leftChild];
            }
            
            max = Math.max(max, leftIndex[rightChild] - rightIndex[leftChild] + 1);
        }
        
        max = Math.max(max, leftIndex[index] - start + 1);
        max = Math.max(max, end - rightIndex[index] + 1);
        max = Math.max(max, Math.max(maxSize[leftChild], maxSize[rightChild]));
        
        maxSize[index] = max;
    }
    
    public void update(int index, int start, int end, int changeIndex, char changeChar) {
        if(start > end) {
            return;
        }
        
        if(start == end) {
            leftMost[index] = changeChar;
            rightMost[index] = changeChar;
            leftIndex[index] = start;
            rightIndex[index] = start;
            return;
        }
        
        int mid = start + (end - start) / 2;
        
        if(start <= changeIndex && changeIndex <= mid) {
            update(2 * index + 1, start, mid, changeIndex, changeChar);
        } else {
            update(2 * index + 2, mid+1, end, changeIndex, changeChar);
        }
        
        merge(index, start, mid, end);
    }
}