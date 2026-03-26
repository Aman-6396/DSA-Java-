package Leetcode_003_March_2026;

public class Substring_Matching_Pattern_Leetcode_3407 {
    class Solution {
        public boolean hasMatch(String s, String p) {
            int idx = p.indexOf('*');

            String p1 = p.substring(0, idx);
            String p2 = p.substring(idx + 1);

            int i = 0; // for String s
            int j = 0; // for String p1
            int k = 0; // for String p2

            // Check string p1 in string s
            int count1 = 0;
            while (i < s.length() && j < p1.length()) {
                if (s.charAt(i) == p1.charAt(j)) {
                    count1++;
                    i++;
                    j++;
                } else if (s.charAt(i) != p1.charAt(j)) {
                    if (count1 > 0) {
                        j = 0;
                        i = i - count1;
                        count1 = 0;
                    }
                    i++;
                }

            }

            if (j < p1.length()) {
                return false;

            } else {
                // Check string p2 in string s
                int count2 = 0;
                while (i < s.length() && k < p2.length()) {
                    if (s.charAt(i) == p2.charAt(k)) {
                        count2++;
                        i++;
                        k++;
                    } else if (s.charAt(i) != p2.charAt(k)) {

                        if (count2 > 0) {
                            k = 0;
                            i = i - count2;
                            count2 = 0;
                        }
                        i++;

                    }

                }

                return (k < p2.length()) ? false : true;
            }

        }
    }
}
