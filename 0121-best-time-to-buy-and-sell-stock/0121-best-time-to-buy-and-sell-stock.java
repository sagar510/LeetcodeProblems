class Solution {
    public int maxProfit(int[] prices) {
        int minsofar = prices[0];
        int maxProfit = 0, profit;
        for(int price : prices){
            if(price < minsofar) minsofar = price;
            profit = price - minsofar;
            if(profit > maxProfit) maxProfit = profit;
        }

        return maxProfit;
    }
}