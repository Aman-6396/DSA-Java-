public class Longest_Repeating_Character_Replacement_Leetcode_424 {
    class Solution {
        public int characterReplacement(String s, int k) {
            int ans = 0;
            int prev = 0;
            int maxFreq = 0;
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'A']++;
                maxFreq = Math.max(maxFreq, freq[s.charAt(i) - 'A']);
                while ((i - prev + 1) - maxFreq > k) {
                    freq[s.charAt(prev) - 'A']--;
                    prev++;
                }
                ans = Math.max(ans, i - prev + 1);
            }
            return ans;
        }
    }
}
