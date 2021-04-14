class MKAverage {
    Queue<Integer> q = new LinkedList<>();;
    int m = 0;
    int k = 0;
    TreeMap<Integer, Integer> max = new TreeMap<>();
    TreeMap<Integer, Integer> min = new TreeMap<>();
    TreeMap<Integer, Integer> mid = new TreeMap<>();
    int minSize = 0;
    int maxSize = 0;
    int sum = 0;
    
    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;    
    }
    
    public void addElement(int num) {
        q.offer(num);
        mid.put(num, mid.getOrDefault(num, 0)+1);
        sum += num;
        
        while(q.size() > m) {
            int item = q.poll();
            
            if(min.containsKey(item)) {
                min.put(item, min.get(item) - 1);
                
                if(min.get(item) == 0) {
                    min.remove(item);
                }
                
                minSize--;
            } else if(mid.containsKey(item)) {
                mid.put(item, mid.get(item)-1);
                
                sum -= item;
                
                if(mid.get(item) == 0) {
                    mid.remove(item);
                }
            } else if(max.containsKey(item)) {
                max.put(item, max.get(item)-1);
                
                if(max.get(item) == 0) {
                    max.remove(item);
                }
                
                maxSize--;
            }
        }
        
        
        while(minSize < k && !mid.isEmpty()) {
            int item = mid.firstKey();
            
            mid.put(item, mid.get(item) - 1);
            if(mid.get(item) == 0) {
                mid.remove(item);
            }
            
            min.put(item, min.getOrDefault(item, 0)+1);
            minSize++;
            sum -= item;
        }
        
        while(!min.isEmpty() && !mid.isEmpty() && min.lastKey() > mid.firstKey()) {
            int item = mid.firstKey();
            int first = min.lastKey();
            
            sum += first;
            sum -= item;
            mid.put(item, mid.get(item) - 1);
            if(mid.get(item) == 0) {
                mid.remove(item);
            }
            mid.put(first, mid.getOrDefault(first, 0)+1);
            
            
            min.put(first, min.get(first)-1);
            if(min.get(first) == 0) {
                min.remove(first);
            }
            min.put(item, min.getOrDefault(item, 0)+1);
        }
        
        while(maxSize < k && !mid.isEmpty()) {
            int item = mid.lastKey();
            
            mid.put(item, mid.get(item) - 1);
            if(mid.get(item) == 0) {
                mid.remove(item);
            }
            
            max.put(item, max.getOrDefault(item, 0)+1);
            maxSize++;
            sum -= item;
        }
        
        while(!max.isEmpty() && !mid.isEmpty() && max.firstKey() < mid.lastKey()) {
            int item = mid.lastKey();
            int first = max.firstKey();
            
            sum += first;
            sum -= item;
            
            mid.put(item, mid.get(item) - 1);
            if(mid.get(item) == 0) {
                mid.remove(item);
            }
            mid.put(first, mid.getOrDefault(first, 0)+1);
            
            
            max.put(first, max.get(first)-1);
            if(max.get(first) == 0) {
                max.remove(first);
            }
            max.put(item, max.getOrDefault(item, 0)+1);
        }
    }
    
    public int calculateMKAverage() {
        if(q.size() < m)
            return -1;
        
        return Math.round((sum / (m - 2*k)));
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */