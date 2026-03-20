import java.util.ArrayList;
import java.util.List;

public class Combinations_Leetcode_77 {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {

            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> ll = new ArrayList<>();
            combination(n, k, 1, ll, ans);
            return ans;

        }

        public static void combination(int n, int k, int idx, List<Integer> ll, List<List<Integer>> ans) {
            if (k == 0) {
                ans.add(new ArrayList<>(ll));
                return;
            }

            for (int i = idx; i <= n; i++) {
                ll.add(i);
                combination(n, k - 1, idx + 1, ll, ans);
                ll.remove(ll.size() - 1);
            }
        }

    }
}
