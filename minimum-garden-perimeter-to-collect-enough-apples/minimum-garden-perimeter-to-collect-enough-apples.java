class Solution {
    public long minimumPerimeter(long neededApples) {
        long res = 2;
        long start = 12;
        long degree = 4;
        long degree2 = 5;
        long total = start;
        
        while(total < neededApples) {
            total += start * degree;
            degree += degree2;
            degree2 += 2;
            res += 2;
        }
        
        return res * 4;
    }
}