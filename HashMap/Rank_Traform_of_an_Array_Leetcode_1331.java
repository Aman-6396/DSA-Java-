import java.util.Arrays;
import java.util.HashMap;

public class Rank_Traform_of_an_Array_Leetcode_1331 {
    class Solution {
        public int[] arrayRankTransform(int[] arr) {
            int[] brr = arr.clone();

            Arrays.sort(brr);
            HashMap<Integer, Integer> map = new HashMap<>();
            int idx = 1;
            for (int i = 0; i < brr.length; i++) {
                if (!map.containsKey(brr[i])) {
                    map.put(brr[i], idx++);
                }
            }
            int[] ans = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                ans[i] = map.get(arr[i]);
            }

            return ans;

        }
    }
}
