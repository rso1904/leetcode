class Solution {
    public int kIncreasing(int[] arr, int k) {
        int lis = 0;
        
        for(int i=0; i < k; i++) {
            lis += getLis(arr, i, k);    
        }
        
        return arr.length - lis;
    }
    
    private int getLis(int[] arr, int index, int k) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=index; i < arr.length; i += k) {
            if(list.isEmpty() || list.get(list.size()-1) <= arr[i]) {
                list.add(arr[i]);
            } else {
                int j = upper(list, arr[i]);
                list.set(j, arr[i]);
            }
        }
        
        return list.size();
    }
    
    private int upper(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            
            if(list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}