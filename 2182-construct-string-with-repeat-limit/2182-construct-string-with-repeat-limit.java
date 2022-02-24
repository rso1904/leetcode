class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Character> max = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Character> temp = new PriorityQueue<>((a, b) -> b - a);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i < s.length(); i++) {
            max.offer(s.charAt(i));
        }
        
        while(!max.isEmpty()) {
            if(sb.length() == 0 || sb.charAt(sb.length()-1) == max.peek() && count < repeatLimit) {
                sb.append(max.poll());
                count++;
            } else if(sb.charAt(sb.length()-1) != max.peek()) {
                sb.append(max.poll());
                count = 0;
                count++;
            }
            
            if(count == repeatLimit) {
                while(!max.isEmpty() && sb.charAt(sb.length()-1) == max.peek()) {
                    temp.offer(max.poll());
                }
                
                if(max.isEmpty())
                    break;
                
                sb.append(max.poll());
                count = 0;
                count++;
                boolean first = false;
                
                while(!temp.isEmpty()) {
                    if(!first) {
                        count = 0;
                        first = true;
                    }
                    
                    sb.append(temp.poll());
                    count++;
                    
                    if(count == repeatLimit) {
                        if(max.isEmpty())
                            break;
                        
                        sb.append(max.poll());
                        if(temp.isEmpty()) {
                            count = 1;
                        } else {
                            count = 0;
                        }
                    }
                }
            }
        }
        
        return sb.toString();
    }
}