import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II_Leetcode_40 {

    class Solution {

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(candidates);

            combination2(candidates, target, 0, new ArrayList<>(), ans);
            return ans;
        }

        public static void combination2(int[] candidates, int target, int i,
                List<Integer> ll, List<List<Integer>> ans) {

            if (target == 0) {
                ans.add(new ArrayList<>(ll));
                return;
            }

            for (int j = i; j < candidates.length; j++) {

                if (j > i && candidates[j] == candidates[j - 1]) {
                    continue;
                }

                if (candidates[j] > target) {
                    break;
                }

                ll.add(candidates[j]);

                combination2(candidates, target - candidates[j], j + 1, ll, ans);

                ll.remove(ll.size() - 1);
            }
        }
    }
}
