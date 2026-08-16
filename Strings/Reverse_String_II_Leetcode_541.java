public class Reverse_String_II_Leetcode_541 {
    class Solution {
        public String reverseStr(String s, int k) {
            StringBuilder sb = new StringBuilder(s);
            int len = sb.length();
            int i = 0;
            while (i < len) {
                if (i + k <= len) {
                    StringBuilder part = new StringBuilder(sb.substring(i, i + k));
                    part.reverse();
                    sb.replace(i, i + k, part.toString());
                } else {
                    StringBuilder part = new StringBuilder(sb.substring(i));
                    part.reverse();
                    sb.replace(i, len, part.toString());
                }
                i = i + (2 * k);
            }
            return sb.toString();
        }
    }
}
