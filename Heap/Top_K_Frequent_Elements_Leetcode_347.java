import java.util.HashMap;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements_Leetcode_347 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1])// if freq. same then arrange according a[1]
                            : Integer.compare(b[0], a[0])); // // reverse for max heap

            // add values in hashmap with their frequiences
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else {
                    map.put(nums[i], 1);
                }
            }

            // add frequencies with their values in PriorityQueue(max)
            for (int v : map.keySet()) {
                pq.add(new int[] { map.get(v), v });
            }

            // create ans array
            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                int[] a = pq.poll();
                ans[i] = a[1];
            }

            return ans;

        }
    }
}
