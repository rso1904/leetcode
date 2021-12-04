class Solution {
    
    private List<Long> mirror1 = new ArrayList<>();
    private List<Long> mirror2 = new ArrayList<>();
    
    public long kMirror(int k, int n) {
        long res = 0;
        
        mirror1.add(0L);
        mirror2.add(0L);
        
        for(int i=1; n > 0 && i < 10; i++) {
            mirror2.add((long)i);
            
            if(isMirror(i, k)) {
                res += i;
                n--;
            }
        }
        
        return res + generate(2, n, k, 10);
    }
    
    private boolean isMirror(long num, int base) {
        long multi = 1;
        
        while(multi * base <= num) {
            multi *= base;
        }
        
        while(num > 0) {
            if(num / multi != num % base) {
                return false;
            }
            
            num = (num - (num / multi) * multi - num % base) / base;
            multi /= base * base;
        }
        
        return true;
    }
    
    private long generate(int digit, int n, int k, long firstMulti) {
        List<Long> mirror = new ArrayList<>();
        long res = 0;
        
        for(int i=0; n > 0 && i < 10; i++) {
            for(int j=0; n > 0 && j < mirror1.size(); j++) {
                mirror.add(firstMulti * i + mirror1.get(j) * 10 + i);
                if(i != 0 && isMirror(mirror.get(mirror.size()-1), k)) {
                    res += mirror.get(mirror.size()-1);
                    n--;
                }
            }
        }
        
        swap(mirror1, mirror2);
        swap(mirror2, mirror);
        
        return res + (n == 0 ? 0 : generate(digit+1, n, k, firstMulti*10));
    }
    
    private void swap(List<Long> list1 , List<Long> list2) {
        List<Long> temp = new ArrayList<>(list1);
        list1.clear();
        list1.addAll(list2);
        list2.clear();
        list2.addAll(temp);
    }
}