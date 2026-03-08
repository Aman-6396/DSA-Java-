import java.util.Arrays;

public class Most_Profit_Assigning_Work_Leetcode_826 {
    class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            return maxProfit(difficulty, profit, worker);
        }

        public static int maxProfit(int[] diff, int[] profit, int[] worker) {

            int[][] job = new int[profit.length][2];
            for (int i = 0; i < job.length; i++) {
                job[i][0] = diff[i];
                job[i][1] = profit[i];
            }
            Arrays.sort(job, (a, b) -> a[0] - b[0]);// sort job in ascending order of difficulty
            Arrays.sort(worker);

            int ans = 0;
            int max = 0;
            int j = 0;
            for (int i = 0; i < worker.length; i++) {

                while (j < job.length && job[j][0] <= worker[i]) {
                    max = Math.max(max, job[j][1]);
                    j++;
                }

                ans += max;

            }

            return ans;

        }
    }
}
