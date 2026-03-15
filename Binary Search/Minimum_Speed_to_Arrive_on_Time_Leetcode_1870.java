public class Minimum_Speed_to_Arrive_on_Time_Leetcode_1870 {
    class Solution {
        public int minSpeedOnTime(int[] dist, double hour) {
            return minSpeed(dist, hour);
        }

        public static int minSpeed(int[] dist, double hour) {
            int left = 1;
            int right = 10000000;
            int ans = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                boolean possible = true;
                double time = 0;
                for (int i = 0; i < dist.length; i++) {
                    time = Math.ceil(time);
                    time += dist[i] * 1.0 / mid;
                    if (time > hour) {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }

            return ans;
        }
    }
}
