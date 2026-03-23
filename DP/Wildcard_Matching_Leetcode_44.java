public class Wildcard_Matching_Leetcode_44 {
    // By Top Down approach
    // class Solution {
    // public boolean isMatch(String s, String p) {
    // Boolean[][] dp = new Boolean[s.length()][p.length()];
    // return match(s, p, s.length() - 1, p.length() - 1, dp);
    // }

    // public static boolean match(String s, String p, int i, int j, Boolean[][] dp)
    // {

    // // Base cases
    // if (i < 0 && j < 0) {
    // return true;
    // }
    // if (j < 0 && i >= 0) {
    // return false;
    // }
    // if (i < 0 && j >= 0) {
    // for (int k = j; k >= 0; k--) {
    // if (p.charAt(k) != '*') {
    // return false;
    // }
    // }
    // return true;
    // }

    // if (dp[i][j] != null) {
    // return dp[i][j];
    // }

    // // String matching with Recursion
    // if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
    // return dp[i][j] = match(s, p, i - 1, j - 1, dp);
    // } else if (p.charAt(j) == '*') {
    // return dp[i][j] = match(s, p, i, j - 1, dp) || match(s, p, i - 1, j, dp); //
    // skip || move

    // } else {
    // return dp[i][j] = false;
    // }

    // }
    // }

    // By Bottom Up approach
    class Solution {
        public boolean isMatch(String s, String p) {
            Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
            return match(s, p, dp);
        }

        public static boolean match(String s, String p, Boolean[][] dp) {

            // Fill Base cases
            dp[0][0] = true;

            for (int i = 1; i <= s.length(); i++) {
                dp[i][0] = false;
            }

            for (int j = 1; j <= p.length(); j++) {
                boolean flag = true;
                for (int k = j; k > 0; k--) {
                    if (p.charAt(k - 1) != '*') {
                        flag = false;
                        break;
                    }
                }
                dp[0][j] = flag;
            }

            // Iteration
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= p.length(); j++) {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j]; // skip || use
                    } else {
                        dp[i][j] = false;
                    }
                }
            }

            return dp[s.length()][p.length()];

        }
    }

}
