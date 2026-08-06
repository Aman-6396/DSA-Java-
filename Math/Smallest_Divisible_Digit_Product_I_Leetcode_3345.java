public class Smallest_Divisible_Digit_Product_I_Leetcode_3345 {
    class Solution {
        public int smallestNumber(int n, int t) {
            for (int i = n; i <= 100; i++) {
                int product = 1;
                int num = i;
                while (num > 0) {
                    int rem = num % 10;
                    product *= rem;
                    num = num / 10;
                }
                if (product % t == 0) {
                    return i;
                }
            }
            return -1; // never reach at this line
        }
    }
}
