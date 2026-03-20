import java.util.ArrayList;
import java.util.List;

public class Permutations_II_Leetcode_47 {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
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
                boolean isUnique = true; // for Unique Permutation
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        isUnique = false;
                        break;
                    }
                }

                if (isUnique) {
                    ll.add(val);
                    nums[i] = -11;

                    permutation(nums, ll, ans);
                    ll.remove(ll.size() - 1);// Backtrack
                    nums[i] = val; // Backtrack
                }

            }

        }
    }
}
