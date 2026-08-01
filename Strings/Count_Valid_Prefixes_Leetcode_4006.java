public class Count_Valid_Prefixes_Leetcode_4006 {
    class Solution {
        public int countValidPrefixes(String s) {
            int ans = 0;
            int count0 = 0;
            int count1 = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    count0++;
                } else {
                    count1++;
                }
                if (count0 == count1 || count0 + 1 == count1 || count1 + 1 == count0) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
