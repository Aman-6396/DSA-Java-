public class Gas_Station_Leetcode_134 {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            return canComplete(gas, cost);
        }

        public static int canComplete(int[] gas, int[] cost) {

            int start = 0;
            int currfuel = 0;
            int total = 0;
            int i = 0;

            while (i < gas.length) {

                int diff = gas[i] - cost[i];
                currfuel += diff;
                total += diff;

                if (currfuel < 0) {
                    start = i + 1;
                    currfuel = 0;
                }
                i++;

            }
            return (total >= 0) ? start : -1;

        }
    }
}
