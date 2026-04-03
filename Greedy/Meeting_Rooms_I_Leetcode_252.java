import java.util.Arrays;

public class Meeting_Rooms_I_Leetcode_252 {
    class Solution {
        static boolean canAttend(int[][] arr) {
            Arrays.sort(arr, (a, b) -> a[0] - b[0]); // sort according to start time
            int prevEnd = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][0] < prevEnd) {
                    return false;
                }
                prevEnd = arr[i][1]; // update prev meeting end time
            }
            return true;
        }
    }
}
