public class Jump_Game_III_Leetcode_1306 {
    class Solution {
        public boolean canReach(int[] arr, int start) {
            return reach(arr, start);
        }

        public static boolean reach(int[] arr, int i) {
            if (i >= arr.length || i < 0) {
                return false;
            }
            if (arr[i] == 0) {
                return true;
            }
            if (arr[i] == -1) {
                return false;
            }

            int jump = arr[i];
            arr[i] = -1; // mark visited
            boolean forward = reach(arr, i + jump);
            boolean backward = reach(arr, i - jump);

            return forward || backward;
        }
    }
}
