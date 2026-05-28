public class Check_if_Array_Is_Sorted_and_Rotated_Leetcode_1752 {
    // By finding first minimum index then check circular array is sorted or not
    // class Solution {
    // public boolean check(int[] nums) {
    // int minIdx = 0;
    // for (int i = 1; i < nums.length; i++) {
    // if (nums[i] < nums[minIdx]) {
    // minIdx = i;
    // } else if (nums[i] == nums[minIdx]) {
    // if (nums[i] != nums[i - 1]) {
    // minIdx = i;
    // }
    // }
    // }

    // int i = (minIdx + 1) % nums.length;
    // int prev = nums[minIdx];

    // while (i != minIdx) {
    // if (nums[i] < prev) {
    // return false;
    // }
    // prev = nums[i];
    // i = (i + 1) % nums.length;
    // }
    // return true;

    // }
    // }

    // By finding num of nums[i] > nums[i + 1] if it is greater than 1 then false
    class Solution {
        public boolean check(int[] nums) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > nums[(i + 1) % nums.length]) {
                    count++;
                }
            }
            return count <= 1;
        }
    }
}
