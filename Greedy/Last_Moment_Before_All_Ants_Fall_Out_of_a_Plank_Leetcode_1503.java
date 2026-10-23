public class Last_Moment_Before_All_Ants_Fall_Out_of_a_Plank_Leetcode_1503 {
    class Solution {
        public int getLastMoment(int n, int[] left, int[] right) {
            int ans = 0;
            for (int i = 0; i < left.length; i++) {
                ans = Math.max(ans, left[i] - 0);
            }
            for (int i = 0; i < right.length; i++) {
                ans = Math.max(ans, n - right[i]);
            }
            return ans;
        }
    }
}
