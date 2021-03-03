class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        
        for(int i=0; i < groups.length; i++) {
            for(int j=0; j < groups[i].length; j++) {
                list.add(groups[i][j]);
            }
            
            boolean check = false;
            
            for(int j=index; j < nums.length; j++) {
                int listIndex = 0;
                
                for(int k=j; k < nums.length; k++) {
                    if(list.get(listIndex) == nums[k]) {
                        listIndex++;
                        if(listIndex >= list.size()) {
                            index = k+1;
                            check = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                
                if(check)
                    break;
            }
            
            if(!check)
                return false;
            
            list.clear();
        }
        
        
        return true;
    }
}