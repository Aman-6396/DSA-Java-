import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II_Leetcode_90 {
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> ll = new ArrayList<>();
            Arrays.sort(nums); // for unique subsets
            findSubsets(nums, 0, ll, ans);
            return ans;
        }

        public static void findSubsets(int[] nums, int idx, List<Integer> ll, List<List<Integer>> ans) {

            ans.add(new ArrayList<Integer>(ll)); // add all subsets

            for (int i = idx; i < nums.length; i++) {
                if (i > idx && nums[i] == nums[i - 1]) {
                    continue;
                }

                ll.add(nums[i]);
                findSubsets(nums, i + 1, ll, ans);
                ll.remove(ll.size() - 1);
            }

        }
    }
}
