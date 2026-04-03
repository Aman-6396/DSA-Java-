import java.util.Arrays;
import java.util.PriorityQueue;

public class Meeting_Rooms_II_Leetcode_253 {
    class Solution {
        public int minMeetingRooms(int[] start, int[] end) {
            int[][] arr = new int[start.length][2];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = start[i];
                arr[i][1] = end[i];
            }
            Arrays.sort(arr, (a, b) -> a[0] - b[0]);// sort according to start time
            pq.add(arr[0][1]); // add first meeting end time
            int room = 1; // atleast 1 room is required

            for (int i = 1; i < arr.length; i++) {
                if (arr[i][0] >= pq.peek()) {
                    pq.poll();
                } else {
                    room++;
                }
                pq.add(arr[i][1]);
            }

            return room;

        }
    }
}
