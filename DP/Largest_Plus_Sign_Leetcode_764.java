import java.util.Arrays;

public class Largest_Plus_Sign_Leetcode_764 {
    class Solution {
        public int orderOfLargestPlusSign(int n, int[][] mines) {
            int[][] matrix = new int[n][n];
            int[][] left = new int[n][n];
            int[][] right = new int[n][n];
            int[][] up = new int[n][n];
            int[][] down = new int[n][n];

            for (int[] a : matrix) {
                Arrays.fill(a, 1);
            }

            for (int i = 0; i < mines.length; i++) {
                int x = mines[i][0];
                int y = mines[i][1];

                matrix[x][y] = 0;// update value
            }

            // fill left dp
            for (int i = 0; i < left.length; i++) { // Row
                left[i][0] = matrix[i][0];
            }
            for (int i = 0; i < left.length; i++) { // Row
                for (int j = 1; j < left[0].length; j++) { // Column
                    if (matrix[i][j] == 1) {
                        left[i][j] = 1 + left[i][j - 1];
                    } else {// matrix[i][j] == 0
                        left[i][j] = 0;
                    }
                }
            }

            // fill right dp
            for (int i = 0; i < right.length; i++) { // Row
                right[i][n - 1] = matrix[i][n - 1];
            }
            for (int i = 0; i < right.length; i++) { // Row
                for (int j = n - 2; j >= 0; j--) { // Column
                    if (matrix[i][j] == 1) {
                        right[i][j] = 1 + right[i][j + 1];
                    } else {// matrix[i][j] == 0
                        right[i][j] = 0;
                    }
                }
            }

            // fill up dp
            for (int i = 0; i < up[0].length; i++) { // Column
                up[n - 1][i] = matrix[n - 1][i];
            }
            for (int i = 0; i < up[0].length; i++) { // Column
                for (int j = n - 2; j >= 0; j--) { // Row
                    if (matrix[j][i] == 1) {
                        up[j][i] = 1 + up[j + 1][i];
                    } else {// matrix[j][i] == 0
                        up[j][i] = 0;
                    }
                }
            }

            // fill down dp
            for (int i = 0; i < down[0].length; i++) { // Column
                down[0][i] = matrix[0][i];
            }
            for (int i = 0; i < down[0].length; i++) { // Column
                for (int j = 1; j < down.length; j++) { // Row
                    if (matrix[j][i] == 1) {
                        down[j][i] = 1 + down[j - 1][i];
                    } else {// matrix[j][i] == 0
                        down[j][i] = 0;
                    }
                }
            }
            int maxplus = 0;
            // Check plus

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 1) {
                        maxplus = Math.max(maxplus, Math.min(left[i][j],
                                Math.min(right[i][j], Math.min(up[i][j], down[i][j]))));
                    }
                }
            }

            return maxplus;

        }
    }
}
