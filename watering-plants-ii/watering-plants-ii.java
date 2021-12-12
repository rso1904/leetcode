class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int res = 0;
        int curA = capacityA;
        int curB = capacityB;
        
        for(int i=0; i < (plants.length + 1) / 2; i++) {
            if(i == (plants.length - i - 1)) {
                if(curA >= curB) {
                    if(plants[i] <= curA) {
                        curA -= plants[i];
                    } else {
                        curA = capacityA;
                        res += 1;
                        curA -= plants[i];
                    }
                } else {
                    if(plants[plants.length - i - 1] <= curB) {
                        curB -= plants[i];
                    } else {
                        curB = capacityB;
                        res += 1;
                        curB -= plants[i];
                    }
                }
                
                break;
            }
            
            if(plants[i] <= curA) {
                curA -= plants[i];
            } else {
                curA = capacityA;
                res += 1;
                curA -= plants[i];
            }
            
            if(plants[plants.length - i - 1] <= curB) {
                curB -= plants[plants.length - i - 1];
            } else {
                curB = capacityB;
                res += 1;
                curB -= plants[plants.length - i - 1];
            }
        }
        
        return res;
    }
}