public class Surrounded_Regions_Leetcode_130 {
    class Solution {
        public void solve(char[][] board) {
            int row = board.length;
            int col = board[0].length;
            int[][] arr = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'X') {
                        arr[i][j] = 1;
                    } else { // board[i][j] == 'O'
                        arr[i][j] = 0;
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O' && arr[i][j] == 0) {
                        if (isSurrounding(board, new int[row][col], i, j, row, col) && fillArr(arr, i, j, row, col)) {
                            fillBoard(board, i, j, row, col);
                        }
                    }
                }
            }
        }

        public static boolean isSurrounding(char[][] board, int[][] arr, int i, int j, int row, int col) {
            if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                return false;
            }

            arr[i][j] = 1; // mark as visited

            boolean up = true;
            boolean down = true;
            boolean left = true;
            boolean right = true;

            if (i > 0 && board[i - 1][j] == 'O' && arr[i - 1][j] == 0) {
                up = isSurrounding(board, arr, i - 1, j, row, col);
            }
            if (i < row - 1 && board[i + 1][j] == 'O' && arr[i + 1][j] == 0) {
                down = isSurrounding(board, arr, i + 1, j, row, col);
            }
            if (j > 0 && board[i][j - 1] == 'O' && arr[i][j - 1] == 0) {
                left = isSurrounding(board, arr, i, j - 1, row, col);
            }
            if (j < col - 1 && board[i][j + 1] == 'O' && arr[i][j + 1] == 0) {
                right = isSurrounding(board, arr, i, j + 1, row, col);
            }
            return up && down && left && right;
        }

        public static boolean fillArr(int[][] arr, int i, int j, int row, int col) {

            arr[i][j] = 1; // marked as visited

            if (i > 0 && arr[i - 1][j] == 0) {
                fillArr(arr, i - 1, j, row, col);
            }
            if (i < row - 1 && arr[i + 1][j] == 0) {
                fillArr(arr, i + 1, j, row, col);
            }
            if (j > 0 && arr[i][j - 1] == 0) {
                fillArr(arr, i, j - 1, row, col);
            }
            if (j < col - 1 && arr[i][j + 1] == 0) {
                fillArr(arr, i, j + 1, row, col);
            }
            return true;
        }

        public static void fillBoard(char[][] board, int i, int j, int row, int col) {

            board[i][j] = 'X'; // surrounding resign

            if (i > 0 && board[i - 1][j] == 'O') {
                fillBoard(board, i - 1, j, row, col);
            }
            if (i < row - 1 && board[i + 1][j] == 'O') {
                fillBoard(board, i + 1, j, row, col);
            }
            if (j > 0 && board[i][j - 1] == 'O') {
                fillBoard(board, i, j - 1, row, col);
            }
            if (j < col - 1 && board[i][j + 1] == 'O') {
                fillBoard(board, i, j + 1, row, col);
            }
        }
    }
}
