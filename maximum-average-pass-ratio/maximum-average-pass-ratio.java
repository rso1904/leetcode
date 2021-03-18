class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>((a, b) -> Double.compare(b[0], a[0]));
        double res = 0;
        
        for(int i=0; i < classes.length; i++) {
            double next = (double)(classes[i][0]+1) / (classes[i][1]+1);
            double prev = (double)classes[i][0] / classes[i][1];
            pq.offer(new double[]{next - prev, classes[i][0], classes[i][1]});
        }
        
        for(int i=0; i < extraStudents; i++) {
            double[] item = pq.poll();
            
            item[1]++;
            item[2]++;
            double next = (item[1]+1) / (item[2]+1);
            double prev = item[1] / item[2];
            
            pq.offer(new double[]{next - prev, item[1], item[2]});
        }
        
        double size = pq.size();
        
        while(!pq.isEmpty()) {
            double[] value = pq.poll();
            res += (value[1] / value[2]);
        }
        
        return res / size;
    }
}