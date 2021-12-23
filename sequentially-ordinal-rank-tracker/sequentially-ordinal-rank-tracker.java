class SORTracker {
    PriorityQueue<SOR> min = new PriorityQueue<>((a, b) -> {
        if(a.score == b.score) {
            return a.name.compareTo(b.name);
        } else {
            return b.score - a.score;
        }
    });
    
    PriorityQueue<SOR> max = new PriorityQueue<>((a, b) -> {
        if(a.score == b.score) {
            return -1 * a.name.compareTo(b.name);
        } else {
            return a.score - b.score;
        }
    });
    
    int count = 0;
    
    public SORTracker() {
        
    }
    
    public void add(String name, int score) {        
        if(max.size() > 0 && max.peek().score == score) {
            if(max.peek().name.compareTo(name) >= 0) {
                min.offer(max.poll());
                max.offer(new SOR(name, score));
            } else {
                min.offer(new SOR(name, score));
            }
        } else if(max.size() > 0 && max.peek().score < score) {
            min.offer(max.poll());
            max.offer(new SOR(name, score));
        } else {
            min.offer(new SOR(name, score));
        }
    }
    
    public String get() {
        String result = min.peek().name;
        max.offer(min.poll());
        count++;
        
        return result;
    }
}

class SOR {
    String name;
    int score;
    
    public SOR(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */