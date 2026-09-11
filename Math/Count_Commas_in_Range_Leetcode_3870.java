public class Count_Commas_in_Range_Leetcode_3870 {
    class Solution {
        public int countCommas(int n) {
            int count = 0;
            if (n < 1000) {
                return count;
            }
            if (n >= 1000 && n <= 100000) {
                count += n - 1000 + 1;
            }
            return count;
        }
    }
}
