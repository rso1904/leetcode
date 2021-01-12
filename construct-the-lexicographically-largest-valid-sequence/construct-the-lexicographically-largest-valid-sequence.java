class Solution {
    int[] ans;
    
    public int[] constructDistancedSequence(int n) {
        boolean[] visited = new boolean[n];
        int[] arr = new int[2*n-1];
        
        search(arr, 0, visited);
        
        return ans;
    }
    
    private boolean search(int[] arr, int index, boolean[] visited) {
        if(index == arr.length) {
            ans = Arrays.copyOf(arr, arr.length);
            return true;
        }
        
        if(arr[index] != 0)
            return search(arr, index+1, visited);
        
        for(int i = visited.length-1; i >= 0; i--) {
            if((i+1) != 1 && (index + (i+1) >= arr.length || arr[index+(i+1)] != 0))
                continue;
            
            if(!visited[i]) {
                visited[i] = true;
                
                arr[index] = (i+1);
                if((i+1) != 1)
                    arr[index+(i+1)] = (i+1);
                
                boolean check = search(arr, index+1, visited);
                if(check)
                    return true;
                
                arr[index] = 0;
                if((i+1) != 1)
                    arr[index+(i+1)] = 0;
                
                visited[i] = false;
            }
        }
        
        return false;
    }
}
