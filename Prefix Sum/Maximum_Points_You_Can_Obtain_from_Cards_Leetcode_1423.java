public class Maximum_Points_You_Can_Obtain_from_Cards_Leetcode_1423 {
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int[] prefix = new int[k];
            int[] suffix = new int[k];
            prefix[0] = cardPoints[0];
            for (int i = 1; i < k; i++) {
                prefix[i] = prefix[i - 1] + cardPoints[i];
            }
            suffix[k - 1] = cardPoints[cardPoints.length - 1];
            for (int i = k - 2, j = cardPoints.length - 2; i >= 0 && j >= 0; i--, j--) {
                suffix[i] = suffix[i + 1] + cardPoints[j];
            }

            int score = Math.max(prefix[k - 1], suffix[0]);
            for (int i = 0, j = 1; i < k - 1 && j < k; i++, j++) {
                score = Math.max(score, prefix[i] + suffix[j]);
            }
            return score;
        }
    }
}
