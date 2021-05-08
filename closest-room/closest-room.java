class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int[] res = new int[queries.length];
        int[][] query = new int[queries.length][3];
        TreeMap<Integer, Integer> treemap = new TreeMap<>();
        
        for(int i=0; i < rooms.length; i++) {
            treemap.put(rooms[i][0], rooms[i][1]);
        }
        
        for(int i=0; i < queries.length; i++) {
            query[i][0] = queries[i][0];
            query[i][1] = queries[i][1];
            query[i][2] = i;
        }
        
        Arrays.sort(query, (a, b) -> a[1] - b[1]);
        Arrays.sort(rooms, (a, b) -> a[1] - b[1]);
        
        int left = 0;
        int right = rooms.length-1;
        
        for(int i=0; i < query.length; i++) {
            while(left < rooms.length && rooms[left][1] < query[i][1]) {
                treemap.remove(rooms[left][0]);
                left++;
            }
            
            if(left >= rooms.length) {
                res[query[i][2]] = -1;
                continue;
            }
            
            Integer min = treemap.floorKey(query[i][0]);
            Integer max = treemap.higherKey(query[i][0]);
            
            int lvalue = min == null ? Integer.MAX_VALUE : Math.abs(min - query[i][0]);
            int rvalue = max == null ? Integer.MAX_VALUE : Math.abs(max - query[i][0]);
            
            if(lvalue <= rvalue) {
                res[query[i][2]] = min;
            } else {
                res[query[i][2]] = max;
            }
        }
        
        return res;
    }
    /*
    private int lower(int[][] arr, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(arr[mid][0] <= target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        return right;
    }
    
    private int upper(int[][] arr, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(arr[mid][0] <= target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        return left;
    } */
}