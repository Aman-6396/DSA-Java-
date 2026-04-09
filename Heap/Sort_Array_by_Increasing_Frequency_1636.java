import java.util.HashMap;
import java.util.PriorityQueue;

public class Sort_Array_by_Increasing_Frequency_1636 {
    class Solution {
        public int[] frequencySort(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> (a[0] == b[0]) ? Integer.compare(b[1], a[1])// if freq. same then arrange acc. to a[1]
                            : Integer.compare(a[0], b[0])); // min heap (increasing order of frequencies)

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

            int i = 0;
            while (!pq.isEmpty()) {
                int[] a = pq.poll();
                for (int j = 0; j < a[0]; j++) {
                    nums[i] = a[1];
                    i++;
                }
            }
            return nums;
        }
    }
}
