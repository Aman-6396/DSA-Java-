public class Removing_Minimum_and_Maximum_From_Array_Leetcode_2091 {
    class Solution {
        public int minimumDeletions(int[] nums) {
            int n = nums.length;
            int idx1 = findMinIdx(nums);
            int idx2 = findMaxIdx(nums);
            return minDeletions(idx1, idx2, n);
        }

        public static int minDeletions(int idx1, int idx2, int n) {
            if (idx1 > idx2) {
                return minDeletions(idx2, idx1, n);
            }

            return Math.min((idx1 + 1) + (n - idx2), Math.min(idx2 + 1, n - idx1));
        }

        public static int findMinIdx(int[] nums) {
            int min = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[min]) {
                    min = i;
                }
            }
            return min;
        }

        public static int findMaxIdx(int[] nums) {
            int max = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[max]) {
                    max = i;
                }
            }
            return max;
        }
    }
}
