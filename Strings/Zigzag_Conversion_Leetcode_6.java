public class Zigzag_Conversion_Leetcode_6 {
    class Solution {
        public String convert(String s, int numRows) {

            if (numRows == 1) {
                return s;
            }

            StringBuilder sb = new StringBuilder();

            for (int row = 0; row < numRows; row++) {
                int idx = row;

                if (idx == 0 || idx == numRows - 1) {
                    while (idx < s.length()) {
                        sb.append(s.charAt(idx));
                        idx += 2 * (numRows - 1);
                    }
                } else {
                    while (idx < s.length()) {
                        sb.append(s.charAt(idx));
                        idx += 2 * (numRows - 1) - 2 * (row);
                        if (idx < s.length()) {
                            sb.append(s.charAt(idx));
                            idx += 2 * row;
                        }
                    }
                }
            }
            return sb.toString();
        }
    }
}
