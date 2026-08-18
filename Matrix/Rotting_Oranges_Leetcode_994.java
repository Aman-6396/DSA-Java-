import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges_Leetcode_994 {
    class Solution {
        public int orangesRotting(int[][] grid) {
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2) {
                        q.offer(new int[] { i, j });
                    }
                }
            }

            // Multi source BFS
            while (!q.isEmpty()) {
                int[] arr = q.poll();
                int r = arr[0];
                int c = arr[1];

                if (r > 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = grid[r][c] + 1;
                    q.add(new int[] { r - 1, c }); // add new rotten orange which can also affect neighbors
                }
                if (r < grid.length - 1 && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = grid[r][c] + 1;
                    q.add(new int[] { r + 1, c });
                }
                if (c > 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = grid[r][c] + 1;
                    q.add(new int[] { r, c - 1 });
                }
                if (c < grid[0].length - 1 && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = grid[r][c] + 1;
                    q.add(new int[] { r, c + 1 });
                }
            }

            // check minimum time
            int max = 2; // because we don't wanna use 0, 1, 2 as they have their own meanings
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    } else {
                        max = Math.max(max, grid[i][j]);
                    }
                }
            }
            return max - 2;
        }
    }
}
