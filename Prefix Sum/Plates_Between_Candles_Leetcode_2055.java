public class Plates_Between_Candles_Leetcode_2055 {
    class Solution {
        public int[] platesBetweenCandles(String s, int[][] queries) {
            int[] pre = new int[s.length()];
            int[] leftArr = new int[s.length()];
            int[] rightArr = new int[s.length()];

            // create leftArr
            int leftcount = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '|') {
                    leftcount = i;
                }
                leftArr[i] = leftcount;
            }

            // create rightArr
            int rightcount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '|') {
                    rightcount = i;
                }
                rightArr[i] = rightcount;
            }

            // create pre array
            int precount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '*') {
                    precount++;
                }
                pre[i] = precount;
            }

            return numberOfPlates(queries, leftArr, rightArr, pre);
        }

        public static int[] numberOfPlates(int[][] queries, int[] leftArr, int[] rightArr, int[] pre) {

            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int leftIdx = queries[i][0];
                int rightIdx = queries[i][1];

                int leftStart = leftArr[leftIdx];
                int rightStart = rightArr[rightIdx];

                if (leftStart <= rightIdx && rightStart >= leftIdx) {
                    ans[i] = pre[rightStart] - pre[leftStart];
                } else {
                    ans[i] = 0;
                }

            }

            return ans;
        }
    }
}
