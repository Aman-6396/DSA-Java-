public class Array_Nesting_Leetcode_565 {
    class Solution {
        public int arrayNesting(int[] nums) {
            int max = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != -1) {
                    int idx = i;
                    int count = 0;
                    while (true) {
                        int val = nums[idx];
                        if (val == -1) {
                            break;
                        }
                        nums[idx] = -1;
                        count++;
                        idx = val;
                    }
                    max = Math.max(max, count);
                }

            }

            return max;
        }
    }
}
