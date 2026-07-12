public class Minimum_Window_Substring_Leetcode_76 {
    class Solution {
        public String minWindow(String s, String t) {
            int[] map = new int[256];
            int m = s.length();
            int n = t.length();
            int minLength = 10000000;
            int startIdx = -1;
            int left = 0;
            int right = 0;
            int count = 0;
            // add frequencies of string t in map array
            for (int i = 0; i < n; i++) {
                map[t.charAt(i)]++;
            }

            // traverse string s
            while (right < m) {
                if (map[s.charAt(right)] > 0) { // present in string t
                    count++;
                }
                map[s.charAt(right)]--;

                while (count == n) { // all elements of string t in substring
                    // check minLength substring
                    if (right - left + 1 < minLength) {
                        minLength = right - left + 1;
                        startIdx = left;
                    }
                    // shrink
                    map[s.charAt(left)]++;
                    if (map[s.charAt(left)] > 0) {
                        count--;
                    }
                    left++;
                }
                right++;
            }

            return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLength);

        }
    }
}
