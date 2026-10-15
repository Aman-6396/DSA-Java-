public class Teemo_Attacking_Leetcode_495 {
    class Solution {
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            int count = 0;
            int last = -1;
            for (int i = 0; i < timeSeries.length; i++) {
                if (last < timeSeries[i]) {
                    count += duration;
                    last = timeSeries[i] + duration - 1;
                } else { // last >= timeSeries[i]
                    count += (timeSeries[i] + duration - 1 - last);
                    last += (timeSeries[i] + duration - 1 - last);
                }
            }
            return count;
        }
    }
}
