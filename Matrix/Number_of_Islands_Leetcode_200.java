public class Number_of_Islands_Leetcode_200 {
    // Time Complexity => O(M * N)
    class Solution {
        public int numIslands(char[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if ((grid[i][j] == '1')) {
                        count++;
                        removeOnes(grid, i, j, grid.length, grid[0].length);
                    }
                }
            }
            return count;
        }

        public static void removeOnes(char[][] grid, int i, int j, int rows, int cols) {
            if (grid[i][j] == '1') {
                grid[i][j] = '0';
            }
            // up
            if (i > 0 && grid[i - 1][j] == '1') {
                removeOnes(grid, i - 1, j, rows, cols);
            }
            // down
            if (i < rows - 1 && grid[i + 1][j] == '1') {
                removeOnes(grid, i + 1, j, rows, cols);
            }
            // left
            if (j > 0 && grid[i][j - 1] == '1') {
                removeOnes(grid, i, j - 1, rows, cols);
            }
            // right
            if (j < cols - 1 && grid[i][j + 1] == '1') {
                removeOnes(grid, i, j + 1, rows, cols);
            }
        }
    }
}
