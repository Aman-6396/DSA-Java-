import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Partition_Labels_Leetcode_763 {
    // Greedy with Time Complexity O(N)
    class Solution {
        public List<Integer> partitionLabels(String s) {
            List<Integer> ans = new ArrayList<>();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), i);
            }

            int max = 0;
            int last = -1;
            for (int i = 0; i < s.length(); i++) {

                max = Math.max(max, map.get(s.charAt(i)));

                if (i == max) {
                    ans.add(max - last);
                    last = max;
                }

            }
            return ans;
        }
    }
}
