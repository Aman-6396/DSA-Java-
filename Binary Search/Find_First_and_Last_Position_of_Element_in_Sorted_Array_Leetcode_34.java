public class Find_First_and_Last_Position_of_Element_in_Sorted_Array_Leetcode_34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {

            int min = findMin(nums, target, 0, nums.length - 1);
            int max = findMax(nums, target, 0, nums.length - 1);

            return new int[] { min, max };
        }

        public static int findMin(int[] nums, int target, int left, int right) {
            int min = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    min = mid;
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }

            return min;

        }

        public static int findMax(int[] nums, int target, int left, int right) {
            int max = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    max = mid;
                    left = mid + 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return max;

        }
    }
}
