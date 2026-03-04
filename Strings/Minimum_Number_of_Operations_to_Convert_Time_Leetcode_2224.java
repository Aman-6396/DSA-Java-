
public class Minimum_Number_of_Operations_to_Convert_Time_Leetcode_2224 {
    class Solution {
        public int convertTime(String current, String correct) {
            return minOperations(current, correct);
        }

        public static int minOperations(String current, String correct) {
            int currenthr = Integer.parseInt(current.substring(0, 2));
            int currentmin = Integer.parseInt(current.substring(3));
            int correcthr = Integer.parseInt(correct.substring(0, 2));
            int correctmin = Integer.parseInt(correct.substring(3));

            int currentTime = currenthr * 60 + currentmin;
            int correctTime = correcthr * 60 + correctmin;

            int timeinterval = correctTime - currentTime;

            int count = 0;
            if (timeinterval >= 60) {
                count += timeinterval / 60;
                timeinterval = timeinterval % 60;
            }
            if (timeinterval >= 15) {
                count += timeinterval / 15;
                timeinterval = timeinterval % 15;
            }
            if (timeinterval >= 5) {
                count += timeinterval / 5;
                timeinterval = timeinterval % 5;
            }
            if (timeinterval >= 1) {
                count += timeinterval / 1;
            }

            return count;

        }
    }
}
