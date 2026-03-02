
import java.util.Arrays;

public class Coin_Change_Leetcode_322 {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[][] dp = new int[amount + 1][coins.length];
            for (int[] v : dp) {
                Arrays.fill(v, -1);
            }
            int c = fewestCoins(coins, amount, 0, dp);
            if (c >= 1000000000) {
                return -1;
            }
            return c;

        }

        public static int fewestCoins(int[] coins, int amount, int idx, int[][] dp) {
            int var = 1000000000;
            if (amount == 0) {
                return 0;
            }
            if (idx == coins.length) {
                return var;
            }
            if (dp[amount][idx] != -1) {
                return dp[amount][idx];
            }

            int inc = var;
            if (coins[idx] <= amount) {
                inc = 1 + fewestCoins(coins, amount - coins[idx], idx, dp);
            }
            int exc = fewestCoins(coins, amount, idx + 1, dp);
            return dp[amount][idx] = Math.min(inc, exc);
        }
    } // Solution class end
}
