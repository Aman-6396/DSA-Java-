public class Max_Area_of_Island_Leetcode_695 {
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int ans = 0;
            int rows = grid.length;
            int cols = grid[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1) {
                        ans = Math.max(ans, maxArea(grid, i, j, rows, cols));
                    }
                }
            }
            return ans;
        }

        public static int maxArea(int[][] grid, int i, int j, int rows, int cols) {
            int sum = 0;
            if (grid[i][j] == 1) {
                sum += 1;
                grid[i][j] = 0; // update the grid index with 0 so that never come to this point
            }

            if (i > 0 && grid[i - 1][j] == 1) {
                sum += maxArea(grid, i - 1, j, rows, cols);
            }
            if (i < rows - 1 && grid[i + 1][j] == 1) {
                sum += maxArea(grid, i + 1, j, rows, cols);
            }
            if (j > 0 && grid[i][j - 1] == 1) {
                sum += maxArea(grid, i, j - 1, rows, cols);
            }
            if (j < cols - 1 && grid[i][j + 1] == 1) {
                sum += maxArea(grid, i, j + 1, rows, cols);
            }
            return sum;
        }
    }
}
