import java.util.Arrays;
import java.util.List;

public class Triangle_Leetcode_120 {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] dp = new int[n][n];
            for (int[] ll : dp) {
                Arrays.fill(ll, Integer.MAX_VALUE);
            }
            return minAns(triangle, 0, 0, dp);
        }

        public static int minAns(List<List<Integer>> triangle, int row, int col, int[][] dp) {
            if (row == triangle.size()) {
                return 0;
            }

            if (dp[row][col] != Integer.MAX_VALUE) {
                return dp[row][col];
            }

            int first = minAns(triangle, row + 1, col, dp);
            int second = minAns(triangle, row + 1, col + 1, dp);
            return dp[row][col] = triangle.get(row).get(col) + Math.min(first, second);
        }
    }
}
