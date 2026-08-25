public class Minimum_Operations_to_Exceed_Threshold_Value_I_Leetcode_3065 {
    class Solution {
        public int minOperations(int[] nums, int k) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < k) {
                    count++;
                }
            }
            return count;
        }
    }
}
