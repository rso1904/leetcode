class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int max = 2 * 1_00_00_1;
        int[] prefix = new int[max];
        int index = 0;
        int res = 0;
        
        for(int i=0; i < 2 * 1_00_00_1; i++) {
            if(index < fruits.length && fruits[index][0] == i) {
                prefix[i] = i == 0 ? fruits[index][1] : prefix[i-1] + fruits[index][1];
                index++;
           //     System.out.println(i + " : " + prefix[i]);
            } else {
                prefix[i] = i == 0 ? 0 : prefix[i-1];
            }
        }
        
        res = Math.max(res, startPos + k < max ? prefix[startPos + k] - prefix[startPos - 1 >= 0 ? startPos - 1 : 0] : prefix[max-1] - prefix[startPos - 1 >= 0 ? startPos - 1 : 0]);
        
        res = Math.max(res, startPos - k - 1 >= 0 ? prefix[startPos] - prefix[startPos - k - 1] : prefix[startPos]);
        
        int rightIndex = startPos + k;
        int leftIndex = startPos - k;
  //      System.out.println(rightIndex + " : " + leftIndex);
        int right = rightIndex;
        int left = startPos;
        
        while(right >= startPos) {
            res = Math.max(res, prefix[right < max ? right : max-1] - (left - 1 >= 0 ? prefix[left-1] : 0));
            right -= 2;
            left -= 1;
        }
        
        right = startPos;
        left = leftIndex;
        
        while(left <= startPos) {
         //       System.out.println(right + " : " + left + " : " + startPos + " : " + prefix[right] + " : " + (left - 1 >= 0 ? prefix[left-1] : 0));
            res = Math.max(res, prefix[right < max ? right : max-1] - (left - 1 >= 0 ? prefix[left-1] : 0));
            right += 1;
            left += 2;
        }
        
        return res;
    }
}