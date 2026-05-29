public class Number_of_Subarrays_with_Bounded_Maximum_Leetcode_795 {
    class Solution {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            int count = 0;
            int prevCount = 0;
            int lastInvalidIdx = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > right) {
                    prevCount = 0;
                    lastInvalidIdx = i;
                } else if (nums[i] >= left) {
                    prevCount = i - lastInvalidIdx;
                }
                count += prevCount;
            }
            return count;
        }
    }
}
