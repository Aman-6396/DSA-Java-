import java.util.ArrayList;
import java.util.List;

public class Permutations_Leetcode_46 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {

            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> ll = new ArrayList<>();
            permutation(nums, ll, ans);
            return ans;

        }

        public static void permutation(int[] nums, List<Integer> ll, List<List<Integer>> ans) {

            if (ll.size() == nums.length) {
                ans.add(new ArrayList<>(ll));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                int val = nums[i];
                if (nums[i] == -11) {
                    continue;
                }
                ll.add(val);
                nums[i] = -11;

                permutation(nums, ll, ans);
                ll.remove(ll.size() - 1);// Backtrack
                nums[i] = val; // Backtrack
            }

        }
    }
}
