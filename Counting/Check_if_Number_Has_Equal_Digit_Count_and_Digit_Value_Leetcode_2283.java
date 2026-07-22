public class Check_if_Number_Has_Equal_Digit_Count_and_Digit_Value_Leetcode_2283 {
    class Solution {
        public boolean digitCount(String num) {
            int[] freq = new int[10];
            for (int i = 0; i < num.length(); i++) {
                freq[num.charAt(i) - '0']++;
            }
            for (int i = 0; i < num.length(); i++) {
                if (freq[i] != num.charAt(i) - '0') {
                    return false;
                }
            }
            return true;
        }
    }
}
