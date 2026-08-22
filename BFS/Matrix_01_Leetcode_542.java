import java.util.LinkedList;
import java.util.Queue;

public class Matrix_01_Leetcode_542 {
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 0) {
                        q.offer(new int[] { i, j });
                    } else {
                        mat[i][j] = -1; // mark as not-visited
                    }
                }
            }

            // Multi source BFS
            while (!q.isEmpty()) {
                int[] arr = q.poll();
                int r = arr[0];
                int c = arr[1];

                // check in four direction - up, down, left, right
                // up
                if (r > 0 && mat[r - 1][c] == -1) {
                    mat[r - 1][c] = mat[r][c] + 1;
                    q.add(new int[] { r - 1, c }); // add new visited in queue for which we also search for - 1 in their
                                                   // nieghbourhood
                }
                // down
                if (r < mat.length - 1 && mat[r + 1][c] == -1) {
                    mat[r + 1][c] = mat[r][c] + 1;
                    q.add(new int[] { r + 1, c });
                }
                // left
                if (c > 0 && mat[r][c - 1] == -1) {
                    mat[r][c - 1] = mat[r][c] + 1;
                    q.add(new int[] { r, c - 1 });
                }
                // right
                if (c < mat[0].length - 1 && mat[r][c + 1] == -1) {
                    mat[r][c + 1] = mat[r][c] + 1;
                    q.add(new int[] { r, c + 1 });
                }
            }
            return mat;
        }
    }
}
