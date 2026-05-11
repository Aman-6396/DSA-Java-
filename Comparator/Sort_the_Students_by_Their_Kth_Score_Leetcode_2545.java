import java.util.Arrays;

public class Sort_the_Students_by_Their_Kth_Score_Leetcode_2545 {
    class Solution {
        public int[][] sortTheStudents(int[][] score, int k) {
            Arrays.sort(score, (a, b) -> Integer.compare(b[k], a[k]));
            return score;
        }
    }
}
