public class Regular_Expression_Matching_Leetcode_10 {
    class Solution {
        public boolean isMatch(String s, String p) {
            Boolean[][] dp = new Boolean[s.length()][p.length()];
            return match(s, p, s.length() - 1, p.length() - 1, dp);
        }

        public static boolean match(String s, String p, int i, int j, Boolean[][] dp) {

            // Base cases
            if (i < 0 && j < 0) {
                return true;
            }
            if (j < 0 && i >= 0) {
                return false;
            }
            if (i < 0 && j >= 0) {
                if (p.charAt(j) == '*') {
                    return match(s, p, i, j - 2, dp);
                }
                return false;
            }

            if (dp[i][j] != null) {
                return dp[i][j];
            }

            // String matching with Recursion
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                return dp[i][j] = match(s, p, i - 1, j - 1, dp);
            } else if (p.charAt(j) == '*') {
                // Skip
                boolean skip = match(s, p, i, j - 2, dp);
                // Use
                boolean use = false;
                if (j > 0 && (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.')) {
                    use = match(s, p, i - 1, j, dp);
                }
                return dp[i][j] = skip || use; // skip || use

            } else {
                return dp[i][j] = false;
            }

        }
    }

}
