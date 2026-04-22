public class Game_of_Life_Leetcode_289 {
    class Solution {
        public void gameOfLife(int[][] board) {
            int row = board.length;
            int col = board[0].length;
            int[][] grid = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    grid[i][j] = board[i][j];
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int live = 0;
                    // Horizontal
                    if (j > 0) { // left
                        if (grid[i][j - 1] == 1) {
                            live++;
                        }
                    }
                    if (j < grid[0].length - 1) { // right
                        if (grid[i][j + 1] == 1) {
                            live++;
                        }
                    }

                    // Vertical
                    if (i > 0) { // up
                        if (grid[i - 1][j] == 1) {
                            live++;
                        }
                    }
                    if (i < grid.length - 1) { // down
                        if (grid[i + 1][j] == 1) {
                            live++;
                        }
                    }

                    // diagonal
                    if (i > 0 && j > 0) {
                        if (grid[i - 1][j - 1] == 1) {
                            live++;
                        }
                    }
                    if (i > 0 && j < grid[0].length - 1) {
                        if (grid[i - 1][j + 1] == 1) {
                            live++;
                        }
                    }
                    if (i < grid.length - 1 && j < grid[0].length - 1) {
                        if (grid[i + 1][j + 1] == 1) {
                            live++;
                        }
                    }
                    if (i < grid.length - 1 && j > 0) {
                        if (grid[i + 1][j - 1] == 1) {
                            live++;
                        }
                    }

                    if (grid[i][j] == 1) {
                        if (live < 2) {
                            board[i][j] = 0;
                        } else if (live == 2 || live == 3) {
                            board[i][j] = 1;
                        } else { // live > 3
                            board[i][j] = 0;
                        }
                    } else { // grid[i][j] == 0
                        if (live == 3) {
                            board[i][j] = 1;
                        }
                    }

                }
            }
        }
    }
}
