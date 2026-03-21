import java.util.ArrayList;
import java.util.List;

public class Subsets_Leetcode_78 {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {

            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> ll = new ArrayList<>();

            findSubsets(nums, 0, ll, ans);
            return ans;

        }

        public static void findSubsets(int[] nums, int idx, List<Integer> ll, List<List<Integer>> ans) {
            if (idx == nums.length) {
                ans.add(new ArrayList<Integer>(ll));
                return;
            }

            findSubsets(nums, idx + 1, ll, ans);// not include
            ll.add(nums[idx]);
            findSubsets(nums, idx + 1, ll, ans); // include
            ll.remove(ll.size() - 1); // backtrack

        }
    }
}
