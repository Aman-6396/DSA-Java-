import java.util.LinkedList;
import java.util.Queue;

public class Map_of_Highest_Peak_Leetcode_1765 {
    class Solution {
        public int[][] highestPeak(int[][] isWater) {
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < isWater.length; i++) {
                for (int j = 0; j < isWater[0].length; j++) {
                    if (isWater[i][j] == 1) {
                        isWater[i][j] = 0;
                        q.offer(new int[] { i, j });
                    } else {
                        isWater[i][j] = -1; // mark as not-visited
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
                if (r > 0 && isWater[r - 1][c] == -1) {
                    isWater[r - 1][c] = isWater[r][c] + 1;
                    q.offer(new int[] { r - 1, c }); // add new visited in queue for which we search also for - 1 in
                                                     // their nieghbourhood

                }
                // down
                if (r < isWater.length - 1 && isWater[r + 1][c] == -1) {
                    isWater[r + 1][c] = isWater[r][c] + 1;
                    q.offer(new int[] { r + 1, c });
                }
                // left
                if (c > 0 && isWater[r][c - 1] == -1) {
                    isWater[r][c - 1] = isWater[r][c] + 1;
                    q.offer(new int[] { r, c - 1 });
                }
                // right
                if (c < isWater[0].length - 1 && isWater[r][c + 1] == -1) {
                    isWater[r][c + 1] = isWater[r][c] + 1;
                    q.offer(new int[] { r, c + 1 });
                }
            }
            return isWater;
        }
    }
}
