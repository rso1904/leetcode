class Solution {
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, (a, b) -> a[0] - b[0]);
        int res = 0;
        int up = 0;
        int down = 0;
        
        for(int i=1; i < stockPrices.length; i++) {
        //    System.out.println(i + " : " + ratio + " : " + stockPrices[i][0] + " : " + stockPrices[i][1] + " : " + res);
            if(i == 1) {
                up = (stockPrices[i][1] - stockPrices[i-1][1]);
                down = (stockPrices[i][0] - stockPrices[i-1][0]);
                res++;
            } else {
                int upT = (stockPrices[i][1] - stockPrices[i-1][1]);
                int downT = (stockPrices[i][0] - stockPrices[i-1][0]);
               
                if(up * downT != down * upT) {
                    up = upT;
                    down = downT;
                    res++;
                }
            }
        }
        
        return res;
    }
}