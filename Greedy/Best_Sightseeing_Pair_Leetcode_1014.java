public class Best_Sightseeing_Pair_Leetcode_1014 {
    class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            int best = values[0] + 0;
            int max = Integer.MIN_VALUE;

            for (int j = 1; j < values.length; j++) {
                max = Math.max(max, best + values[j] - j);
                best = Math.max(best, values[j] + j);
            }

            return max;

        }
    }
}
