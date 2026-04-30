public class The_Two_Sneaky_Numbers_of_Digitville_Leetcode_3289 {
    class Solution {
        public int[] getSneakyNumbers(int[] nums) {
            int[] ans = new int[2];
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                int idx = -1;
                if (nums[i] == -100000) {
                    idx = 0;
                } else {
                    idx = Math.abs(nums[i]);
                }

                if (nums[idx] > 0) {
                    nums[idx] = -nums[idx];
                } else if (nums[idx] == 0) {
                    nums[idx] = -100000;
                } else { // nums[idx] < 0
                    ans[j] = idx;
                    j++;
                }
            }
            return ans;
        }
    }
}
