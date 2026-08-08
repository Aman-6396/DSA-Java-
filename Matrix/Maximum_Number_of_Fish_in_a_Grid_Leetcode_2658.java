public class Maximum_Number_of_Fish_in_a_Grid_Leetcode_2658 {
    class Solution {
        public int findMaxFish(int[][] grid) {
            int ans = 0;
            int rows = grid.length;
            int cols = grid[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] > 0) {
                        int sum = findMax(grid, i, j, rows, cols);
                        ans = Math.max(ans, sum);
                    }
                }
            }
            return ans;
        }

        public static int findMax(int[][] grid, int i, int j, int rows, int cols) {
            int sum = 0;
            if (grid[i][j] > 0) {
                sum += grid[i][j];
                grid[i][j] = 0; // update it with 0
            }
            if (i > 0 && grid[i - 1][j] > 0) {
                sum += findMax(grid, i - 1, j, rows, cols);
            }
            if (i < rows - 1 && grid[i + 1][j] > 0) {
                sum += findMax(grid, i + 1, j, rows, cols);
            }
            if (j > 0 && grid[i][j - 1] > 0) {
                sum += findMax(grid, i, j - 1, rows, cols);
            }
            if (j < cols - 1 && grid[i][j + 1] > 0) {
                sum += findMax(grid, i, j + 1, rows, cols);
            }

            return sum;
        }
    }
}
