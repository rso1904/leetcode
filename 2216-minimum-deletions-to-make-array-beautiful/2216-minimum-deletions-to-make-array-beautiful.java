class Solution {
    public int minDeletion(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        int res = 0;
        
        for(int i=0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        
        while(index < list.size()) {
            int i = index;
            
            for(; i < list.size(); i++) {
                if((i+1 < list.size()) && (list.get(i).equals(list.get(i+1)))) {
                    continue;
                } else {
                    break;
                }
            }
            
            for(int j=index+1; j <= i; j++) {
                list.remove(index+1);
                res++;
            }
            
            index += 2;
        }
        
        if(list.size() % 2 != 0) {
            list.remove(list.size()-1);
            res++;
        }
        
        return res;
    }
}