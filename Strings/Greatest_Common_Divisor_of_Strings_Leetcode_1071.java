package Leetcode_003_March_2026;

public class Greatest_Common_Divisor_of_Strings_Leetcode_1071 {
    class Solution {
        public String gcdOfStrings(String str1, String str2) {
            if (str1.length() >= str2.length()) {
                return gcd(str1, str2);
            }
            return gcd(str2, str1);
        }

        public static String gcd(String s1, String s2) {

            int n = s1.length();
            int m = s2.length();

            int i = 0;
            int j = 0;
            int p = n - 1;
            int q = m - 1;
            while (i < n) {
                if (s1.charAt(i) != s2.charAt(j)) {
                    return new String();
                } else {
                    i++;
                    j = (j + 1) % m;
                }
            }

            while (p >= 0) {
                if (s1.charAt(p) != s2.charAt(q)) {
                    return new String();
                } else {
                    p--;
                    q = (q - 1 + m) % m;
                }
            }

            if (j == 0 && q == m - 1) {
                return s2;
            } else {
                if (s2.length() % (m - j) == 0) {
                    return s2.substring(0, m - j);
                } else {
                    return gcd(s2, s2.substring(0, m - j));
                }

            }
        }
    }
}
