import java.util.LinkedList;
import java.util.Queue;

public class As_Far_from_Land_as_Possible_Leetcode_1162 {
    class Solution {
        public int maxDistance(int[][] grid) {
            Queue<int[]> q = new LinkedList<>();
            int land = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        q.offer(new int[] { i, j });
                        land++;
                    }
                }
            }

            if (land == 0 || land == grid.length * grid[0].length) {
                return -1;
            }

            while (!q.isEmpty()) {
                int[] arr = q.poll();
                int r = arr[0];
                int c = arr[1];

                if (r > 0 && grid[r - 1][c] == 0) {
                    grid[r - 1][c] = grid[r][c] + 1;
                    q.add(new int[] { r - 1, c });
                }
                if (r < grid.length - 1 && grid[r + 1][c] == 0) {
                    grid[r + 1][c] = grid[r][c] + 1;
                    q.add(new int[] { r + 1, c });
                }
                if (c > 0 && grid[r][c - 1] == 0) {
                    grid[r][c - 1] = grid[r][c] + 1;
                    q.add(new int[] { r, c - 1 });
                }
                if (c < grid[0].length - 1 && grid[r][c + 1] == 0) {
                    grid[r][c + 1] = grid[r][c] + 1;
                    q.add(new int[] { r, c + 1 });
                }
            }

            int max = 1;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    max = Math.max(max, grid[i][j]);
                }
            }
            return max - 1;
        }
    }
}
