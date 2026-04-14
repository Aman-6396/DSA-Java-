public class Jump_Game_Leetcode_55 {
    // My Approach
    // class Solution {
    // public boolean canJump(int[] nums) {
    // if (nums.length == 1) {
    // return true;
    // }
    // if (nums[0] == 0) {
    // return false;
    // }
    // int i = nums.length - 2;
    // while (i > 0) {
    // if (nums[i] == 0) {
    // int ans = check(nums, i, i - 1);
    // if (ans == -1) {
    // return false;
    // } else {
    // i = ans;
    // }
    // }
    // i--;
    // }
    // return true;
    // }

    // public static int check(int[] nums, int target, int i) {

    // while (i >= 0) {
    // if (nums[i] + i > target) {
    // return i;
    // }
    // i--;
    // }
    // return -1;
    // }
    // }

    // Better approach with TC O(n)
    class Solution {
        public boolean canJump(int[] nums) {
            int maxReach = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > maxReach) {
                    return false;
                }
                maxReach = Math.max(maxReach, i + nums[i]);
            }
            return true;
        }
    }

}
