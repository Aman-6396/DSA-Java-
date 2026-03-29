public class Maximal_Square_Leetcode_221 {
    class Solution {
        public int maximalSquare(char[][] matrix) {

            int[][] dp = new int[matrix.length][matrix[0].length];
            int maxLength = 0;

            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[0].length; c++) {

                    if (matrix[r][c] == '1') {
                        if (r > 0 && c > 0) {
                            int up = dp[r - 1][c];
                            int left = dp[r][c - 1];
                            int leftup = dp[r - 1][c - 1];
                            dp[r][c] = Math.min(up, Math.min(left, leftup));
                        }
                        dp[r][c] += 1;
                        maxLength = Math.max(maxLength, dp[r][c]);
                    }

                }
            }
            return maxLength * maxLength;
        }
    }
}
