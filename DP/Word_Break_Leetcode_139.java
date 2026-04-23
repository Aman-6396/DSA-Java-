import java.util.HashSet;
import java.util.List;

public class Word_Break_Leetcode_139 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            HashSet<String> set = new HashSet<>();
            Boolean[] dp = new Boolean[s.length()];
            // add word in set
            for (int i = 0; i < wordDict.size(); i++) {
                set.add(wordDict.get(i));
            }

            return isPossible(s, set, 0, dp);
        }

        public static boolean isPossible(String s, HashSet<String> set, int start, Boolean[] dp) {

            if (start == s.length()) {
                return true;
            }

            if (dp[start] != null) {
                return dp[start];
            }

            StringBuilder sb = new StringBuilder();

            for (int i = start; i < s.length(); i++) {
                sb.append(s.charAt(i));
                if (set.contains(sb.toString())) {
                    if (isPossible(s, set, i + 1, dp)) {
                        return dp[start] = true;
                    }
                }
            }
            return dp[start] = false;

        }
    }
}
