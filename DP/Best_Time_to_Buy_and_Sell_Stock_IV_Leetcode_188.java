public class Best_Time_to_Buy_and_Sell_Stock_IV_Leetcode_188 {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            Integer[][][] dp = new Integer[prices.length][2][k];

            return profit(prices, k, 0, 0, 0, dp);
        }

        public static int profit(int[] prices, int k, int idx, int buy, int count, Integer[][][] dp) {
            if (idx == prices.length || count == k) {
                return 0;
            }

            if (dp[idx][buy][count] != null) {
                return dp[idx][buy][count];
            }

            if (buy == 0) {// buy
                int incBuy = profit(prices, k, idx + 1, 1, count, dp) - prices[idx];
                int excBuy = profit(prices, k, idx + 1, 0, count, dp) - 0; // buy next time
                return dp[idx][buy][count] = Math.max(incBuy, excBuy);
            } else { // sell
                int incSell = profit(prices, k, idx + 1, 0, count + 1, dp) + prices[idx];
                int excSell = profit(prices, k, idx + 1, 1, count, dp) + 0; // sell next time
                return dp[idx][buy][count] = Math.max(incSell, excSell);
            }
        }
    }
}
