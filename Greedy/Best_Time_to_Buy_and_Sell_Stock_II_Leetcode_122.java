public class Best_Time_to_Buy_and_Sell_Stock_II_Leetcode_122 {
    class Solution {
        public int maxProfit(int[] prices) {

            // First Approach by me
            // int minPrice = prices[0];
            // int maxProfit = 0;
            // for (int i = 1; i < prices.length; i++) {
            // int currProfit = prices[i] - minPrice;
            // if (currProfit > 0) {// sell the stock
            // maxProfit += currProfit;
            // minPrice = prices[i];
            // }
            // if (prices[i] < minPrice) {
            // minPrice = prices[i];
            // }
            // }
            // return maxProfit;

            // Second Approach by me
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += (prices[i] - prices[i - 1]);
                }
            }
            return profit;
        }
    }
}
