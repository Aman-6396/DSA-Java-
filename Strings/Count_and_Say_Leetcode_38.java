public class Count_and_Say_Leetcode_38 {
    class Solution {
        public String countAndSay(int n) {
            StringBuilder prev = new StringBuilder("1");
            if (n == 1) {
                return prev.toString();
            }
            for (int i = 2; i <= n; i++) {
                String newRLE = findRLE(prev);
                prev.replace(0, prev.length(), newRLE);
            }

            return prev.toString();
        }

        public static String findRLE(StringBuilder prev) {
            StringBuilder ans = new StringBuilder();
            char ch = prev.charAt(0);
            int count = 1;
            for (int i = 1; i < prev.length(); i++) {
                if (prev.charAt(i) == ch) {
                    count++;
                } else {
                    ans.append(count).append(ch); // append
                    ch = prev.charAt(i); // update ch
                    count = 1;// update count
                }
            }
            ans.append(count).append(ch);// append in end for last character

            return ans.toString();

        }
    }
}
