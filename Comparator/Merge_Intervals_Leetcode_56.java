import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals_Leetcode_56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            List<int[]> ll = new ArrayList<>();
            for (int i = 0; i < intervals.length; i++) {
                if (ll.isEmpty() || intervals[i][0] > ll.get(ll.size() - 1)[1]) {
                    ll.add(new int[] { intervals[i][0], intervals[i][1] });
                } else {
                    int[] temp = ll.get(ll.size() - 1);
                    temp[1] = Math.max(temp[1], intervals[i][1]);
                }
            }
            int[][] ans = new int[ll.size()][2];
            for (int i = 0; i < ll.size(); i++) {
                ans[i][0] = ll.get(i)[0];
                ans[i][1] = ll.get(i)[1];
            }
            return ans;
        }
    }
}
