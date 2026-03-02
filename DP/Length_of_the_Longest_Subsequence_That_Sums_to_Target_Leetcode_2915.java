import java.util.Arrays;
import java.util.List;

public class Length_of_the_Longest_Subsequence_That_Sums_to_Target_Leetcode_2915 {
    class Solution {
        public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
            int[][] dp = new int[target + 1][nums.size()];
            for (int[] v : dp) {
                Arrays.fill(v, -1);
            }
            int c = longestSubsequence(nums, target, 0, dp);
            if (c < 0) {
                return -1;
            }
            return c;
        }

        public static int longestSubsequence(List<Integer> nums, int target, int idx, int[][] dp) {
            int var = Integer.MIN_VALUE;
            if (target == 0) {
                return 0;
            }
            if (idx == nums.size()) {
                return var;
            }
            if (dp[target][idx] != -1) {
                return dp[target][idx];
            }

            int inc = var;
            if (nums.get(idx) <= target) {
                inc = 1 + longestSubsequence(nums, target - nums.get(idx), idx + 1, dp);
            }
            int exc = longestSubsequence(nums, target, idx + 1, dp);
            return dp[target][idx] = Math.max(inc, exc);
        }

    }
}
