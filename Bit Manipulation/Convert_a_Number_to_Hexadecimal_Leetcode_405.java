public class Convert_a_Number_to_Hexadecimal_Leetcode_405 {
    class Solution {
        public String toHex(int num) {
            StringBuilder sb = new StringBuilder();
            if (num == 0) {
                return "0";
            }
            while (num != 0) {
                int val = num & 15;
                if (val == 10) {
                    sb.append('a');
                } else if (val == 11) {
                    sb.append('b');
                } else if (val == 12) {
                    sb.append('c');
                } else if (val == 13) {
                    sb.append('d');
                } else if (val == 14) {
                    sb.append('e');
                } else if (val == 15) {
                    sb.append('f');
                } else {
                    sb.append(val);
                }
                num = num >>> 4;
            }

            return sb.reverse().toString();
        }
    }
}
