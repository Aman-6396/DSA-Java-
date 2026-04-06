import java.util.Arrays;

public class Maximize_the_Topmost_Element_After_K_Moves_Leetcode_2202 {
    class Solution {
        public int maximumTop(int[] nums, int k) {
            if (k == 0) {
                return nums[0];
            }
            if (nums.length == 1) {
                return ((k % 2) == 0) ? nums[0] : -1;
            }
            if (k > nums.length) {
                return Arrays.stream(nums).max().getAsInt();
            }
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < k - 1; i++) {
                maxValue = Math.max(maxValue, nums[i]);
            }
            if (k < nums.length) {
                return Math.max(maxValue, nums[k]);
            }
            return maxValue; // k == nums.length
        }
    }
}
