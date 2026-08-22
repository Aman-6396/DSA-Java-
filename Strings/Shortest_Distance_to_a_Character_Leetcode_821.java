import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Distance_to_a_Character_Leetcode_821 {
    class Solution {
        public int[] shortestToChar(String s, char c) {
            int[] arr = new int[s.length()];
            Arrays.fill(arr, -1);
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    q.offer(i);
                    arr[i] = 0; // for char c we put 0 on that index in arr
                }
            }

            while (!q.isEmpty()) {
                int idx = q.poll();
                if (idx > 0 && arr[idx - 1] < 0) { // i.e. arr[idx - 1] == -1
                    arr[idx - 1] = arr[idx] + 1;
                    q.add(idx - 1);
                }
                if (idx < s.length() - 1 && arr[idx + 1] < 0) {
                    arr[idx + 1] = arr[idx] + 1;
                    q.add(idx + 1);
                }
            }
            return arr;
        }
    }
}
