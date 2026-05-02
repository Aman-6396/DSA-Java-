public class Rotate_Function_Leetcode_396 {
    // Brute Force Approach Time Complexity is O(N^2)
    // class Solution {
    // public int maxRotateFunction(int[] nums) {
    // int ans = Integer.MIN_VALUE;
    // for (int i = 0; i < nums.length; i++) {
    // ans = Math.max(ans, maxFunction(nums, i, 0));
    // }
    // return ans;
    // }

    // public static int maxFunction(int[] nums, int mulIdx, int i) {
    // if (i == nums.length) {
    // return 0;
    // }

    // int sum = (mulIdx * nums[i]) + maxFunction(nums, ((mulIdx + 1) %
    // nums.length), i + 1);
    // return sum;
    // }
    // }

    // Optimized Approach Time Complexity is O(N)

    class Solution {
        public int maxRotateFunction(int[] nums) {
            int totalSum = 0;
            int fVal = 0;
            int n = nums.length;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                totalSum += nums[i];
                fVal += i * nums[i];
            }

            max = Math.max(fVal, max);

            for (int i = n - 1; i > 0; i--) {
                fVal = fVal + totalSum - (n * nums[i]); // formula = prev + totalsum - (n * nums[i])
                max = Math.max(max, fVal);
            }

            return max;
        }
    }
}
