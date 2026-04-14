package Leetcode_004_April_2026;

public class Jump_Game_II_Leetcode_45 {
    // My Approach
    // class Solution {
    // public int jump(int[] nums) {
    // int count = 0;
    // if (nums.length == 1) {
    // return count;
    // }
    // int maxReach = nums[0];
    // for (int i = 1; i < nums.length; i++) {

    // count++;
    // if (maxReach >= nums.length - 1) {
    // return count;
    // }
    // int prev = maxReach;
    // for (int j = i; j <= prev; j++) {
    // if (maxReach < j + nums[j]) {
    // maxReach = j + nums[j];
    // }
    // }
    // i = prev;

    // }
    // return count;
    // }
    // }

    // Better Approach with TC O(n)
    class Solution {
        public int jump(int[] nums) {

            int jumps = 0;
            int currentEnd = 0;
            int farthest = 0;

            for (int i = 0; i < nums.length - 1; i++) {

                farthest = Math.max(farthest, i + nums[i]);

                if (i == currentEnd) {
                    jumps++;
                    currentEnd = farthest;
                }
            }

            return jumps;
        }
    }
}
