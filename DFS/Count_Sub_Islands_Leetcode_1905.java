public class Count_Sub_Islands_Leetcode_1905 {
    class Solution {
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int count = 0;
            for (int i = 0; i < grid1.length; i++) {
                for (int j = 0; j < grid1[0].length; j++) {
                    if (grid2[i][j] == 1 && grid1[i][j] == 1) {
                        if (check(grid1, grid2, i, j)) {
                            count++;
                        }
                    }
                }
            }
            return count;
        }

        public static boolean check(int[][] grid1, int[][] grid2, int i, int j) {

            grid2[i][j] = 0; // marked as visited

            boolean up = true;
            boolean down = true;
            boolean left = true;
            boolean right = true;

            // up
            if (i > 0 && grid2[i - 1][j] == 1) {
                up = check(grid1, grid2, i - 1, j);
            }
            // down
            if (i < grid2.length - 1 && grid2[i + 1][j] == 1) {
                down = check(grid1, grid2, i + 1, j);
            }
            // left
            if (j > 0 && grid2[i][j - 1] == 1) {
                left = check(grid1, grid2, i, j - 1);
            }
            // right
            if (j < grid2[0].length - 1 && grid2[i][j + 1] == 1) {
                right = check(grid1, grid2, i, j + 1);
            }

            if (grid1[i][j] == 0) { // it means grid2[i][j] == 1 && gri1d1[i][j] == 0
                return false;
            }
            return up && down && left && right;
        }
    }
}
