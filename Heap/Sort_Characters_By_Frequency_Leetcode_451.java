import java.util.HashMap;
import java.util.PriorityQueue;

public class Sort_Characters_By_Frequency_Leetcode_451 {
    class Solution {
        public String frequencySort(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1])// if freq same then use lexicographical order
                            : Integer.compare(b[0], a[0])); // otherwise max heap

            // add character and their frequencies in HashMap
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
            }

            // add frequencies and their character in PriorityQueue(max)
            for (char v : map.keySet()) {
                pq.add(new int[] { map.get(v), v });
            }

            // Create ans String
            StringBuilder sb = new StringBuilder();
            while (!pq.isEmpty()) {
                int[] a = pq.poll();
                for (int i = 0; i < a[0]; i++) {
                    sb.append((char) (a[1]));
                }
            }
            return sb.toString();
        }
    }
}
