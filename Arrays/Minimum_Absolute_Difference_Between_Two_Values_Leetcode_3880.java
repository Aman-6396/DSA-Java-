public class Minimum_Absolute_Difference_Between_Two_Values_Leetcode_3880 {
    class Solution {
        public int minAbsoluteDifference(int[] nums) {
            int ans = 1000;
            int one = -1;
            int two = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    one = i;
                } else if (nums[i] == 2) {
                    two = i;
                }

                if (one != -1 && two != -1) {
                    ans = Math.min(ans, Math.abs(one - two));
                }
            }

            if (ans == 1000) {
                return -1;
            }

            return ans;
        }
    }
}
