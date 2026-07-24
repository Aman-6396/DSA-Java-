import java.util.HashMap;

public class Longest_Harmonious_Subsequence_Leetcode_594 {
    class Solution {
        public int findLHS(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            for (int key : map.keySet()) {
                if (map.containsKey(key + 1)) {
                    ans = Math.max(ans, map.get(key) + map.get(key + 1));
                }
            }
            return ans;
        }
    }
}
