public class Furthest_Point_From_Origin_Leetcode_2833 {
    class Solution {
        public int furthestDistanceFromOrigin(String moves) {
            int leftCount = 0;
            int rightCount = 0;
            int blankCount = 0;
            for (int i = 0; i < moves.length(); i++) {
                char ch = moves.charAt(i);
                if (ch == 'R') {
                    rightCount++;
                } else if (ch == 'L') {
                    leftCount++;
                } else {
                    blankCount++;
                }
            }
            return Math.abs(rightCount - leftCount) + blankCount;
        }
    }
}
