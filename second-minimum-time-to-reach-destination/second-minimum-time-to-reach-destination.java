class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Map<Integer, List<Integer>> adjs = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        int first = 0;
        int second = 0;
        int res = 0;
        
        for(int i=0; i < edges.length; i++) {
            adjs.computeIfAbsent(edges[i][0], x -> new ArrayList<>()).add(edges[i][1]);
            adjs.computeIfAbsent(edges[i][1], x -> new ArrayList<>()).add(edges[i][0]);
        }
        
        
        pq.offer(new int[]{1, 0, -1});
        
        while(!pq.isEmpty()) {
            int[] item = pq.poll();
            
            if(item[0] == n) {
                if(count == 0) {
                    count++;
                    first = item[1];
                } else if(first != item[1]) {
                    count++;
                    second = item[1];
                    break;
                } else {
                    continue;
                }
            }
            
            List<Integer> adj = adjs.get(item[0]);
            
            for(Integer ne : adj) {
                if(!visited.contains(ne)) {
                    pq.offer(new int[]{ne, item[1]+1, item[0]});
                    visited.add(item[2]);
                }
            }
        }
    //    System.out.println(first + " : " + second);
        if(count == 2 && first == second-1) {
            int total = change;
            for(int i=0; i < second; i++) {
                res += time;
                
                if(i < second-1) {
                    if(res % change == 0) {
                        int value = res / change;
                        if(value % 2 == 1) {
                            res += change;
                        }
                    } else {
                        int value = res / change;
                        if(value % 2 == 1) {
                            res = change * (value + 1);
                        }
                    }
                }
            }
        } else {
            int total = change;
            for(int i=0; i < first+2; i++) {
                res += time;
                if(i < first+1) {
                    if(res % change == 0) {
                        int value = res / change;
                        if(value % 2 == 1) {
                            res += change;
                        }
                    } else {
                        int value = res / change;
                        if(value % 2 == 1) {
                            res = change * (value + 1);
                        }
                    }
                }
            }
        }
        
        return res;
    }
}