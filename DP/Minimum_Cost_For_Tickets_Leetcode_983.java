import java.util.Arrays;

public class Minimum_Cost_For_Tickets_Leetcode_983 {
    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            int[] dp = new int[days.length];
            Arrays.fill(dp, -1);
            return minCost(days, costs, 0, dp);
        }

        public static int minCost(int[] days, int[] costs, int i, int[] dp) {

            if (i == days.length) {
                return 0;
            }

            if (dp[i] != -1) {
                return dp[i];
            }

            // For 1 day
            int f = i;
            while (f < days.length && days[f] < days[i] + 1) {
                f++;
            }
            int first = costs[0] + minCost(days, costs, f, dp);

            // For 7 day
            int s = i;
            while (s < days.length && days[s] < days[i] + 7) {
                s++;
            }
            int second = costs[1] + minCost(days, costs, s, dp);

            // For 30 day

            int t = i;
            while (t < days.length && days[t] < days[i] + 30) {
                t++;
            }
            int third = costs[2] + minCost(days, costs, t, dp);

            return dp[i] = Math.min(first, Math.min(second, third));
        }
    }
}
