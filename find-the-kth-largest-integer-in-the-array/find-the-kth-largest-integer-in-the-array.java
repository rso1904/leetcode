class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        radixsort(nums);
        /*
        for(int i=0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }*/
        
        return nums[nums.length - k];
    }
    
    private int getMax(String[] arr) {
        int mx = arr[0].length();
        
        for (int i = 1; i < arr.length; i++)
            if (arr[i].length() > mx)
                mx = arr[i].length();
        
        return mx;
    }

    private void countSort(String[] arr, int n, int exp) {
        String[] output = new String[n]; // output array
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        for (int i = 0; i < n; i++) {
            int index = exp < arr[i].length() ? Character.getNumericValue(arr[i].charAt(arr[i].length()-1-exp)) : 0;
            
            count[index]++;
        }
            
 
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        for (int i = n - 1; i >= 0; i--) {
            int index = exp < arr[i].length() ? Character.getNumericValue(arr[i].charAt(arr[i].length()-1-exp)) : 0;

            output[count[index] - 1] = arr[i];
            count[index]--;
        }
 
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    private void radixsort(String[] arr) {
        int m = getMax(arr);
        
        for (int exp = 0; exp < m; exp++)
            countSort(arr, arr.length, exp);
    }
}