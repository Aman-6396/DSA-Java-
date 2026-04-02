import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_III_Leetcode_123 {
    class Solution {
        public int maxProfit(int[] prices) {
            int[][][] dp = new int[prices.length][2][2];
            for (int[][] a : dp) {
                for (int[] b : a) {
                    Arrays.fill(b, -1);
                }
            }

            return profit(prices, 0, 0, 0, dp);
        }

        public static int profit(int[] prices, int idx, int buy, int count, int[][][] dp) {
            if (count == 2 || idx == prices.length) {
                return 0;
            }

            if (dp[idx][buy][count] != -1) {
                return dp[idx][buy][count];
            }

            if (buy == 0) { // buy
                int incBuy = profit(prices, idx + 1, 1, count, dp) - prices[idx];
                int excBuy = profit(prices, idx + 1, 0, count, dp) - 0; // buy next one
                return dp[idx][buy][count] = Math.max(incBuy, excBuy);
            } else { // sell
                int incSell = profit(prices, idx + 1, 0, count + 1, dp) + prices[idx];
                int excSell = profit(prices, idx + 1, 1, count, dp) + 0; // sell next one
                return dp[idx][buy][count] = Math.max(incSell, excSell);
            }
        }
    }

    // By using 2D Dp of dp[n][4] using transaction number rather using buy and
    // cound
    // class Solution {
    // public int maxProfit(int[] prices) {
    // int[][] dp = new int[prices.length][4];
    // for (int[] a : dp) {
    // Arrays.fill(a, -1);
    // }

    // return profit(prices, 0, 0, dp);
    // }

    // public static int profit(int[] prices, int idx, int transaction, int[][] dp)
    // {
    // if (transaction == 4 || idx == prices.length) {
    // return 0;
    // }

    // if (dp[idx][transaction] != -1) {
    // return dp[idx][transaction];
    // }

    // if (transaction % 2 == 0) { // buy for even transactions
    // int incBuy = profit(prices, idx + 1, transaction + 1, dp) - prices[idx];
    // int excBuy = profit(prices, idx + 1, transaction, dp) - 0; // buy next one
    // return dp[idx][transaction] = Math.max(incBuy, excBuy);
    // } else { // sell for odd transactions
    // int incSell = profit(prices, idx + 1, transaction + 1, dp) + prices[idx];
    // int excSell = profit(prices, idx + 1, transaction, dp) + 0; // sell next one
    // return dp[idx][transaction] = Math.max(incSell, excSell);
    // }
    // }
    // }
}
