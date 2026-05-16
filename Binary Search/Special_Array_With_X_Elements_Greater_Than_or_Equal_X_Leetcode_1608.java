import java.util.Arrays;

public class Special_Array_With_X_Elements_Greater_Than_or_Equal_X_Leetcode_1608 {
    // Basic Approach using Sorting + Binary Search with TC O(NlogN)
    class Solution {
        public int specialArray(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            for (int x = 1; x <= n; x++) {
                int idx = -1;
                int left = 0;
                int right = n - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] >= x) {
                        idx = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                if (idx != -1 && n - idx == x) {
                    return x;
                }
            }
            return -1;
        }
    }
}
