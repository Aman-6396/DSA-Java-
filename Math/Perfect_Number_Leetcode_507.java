public class Perfect_Number_Leetcode_507 {
    class Solution {
        public boolean checkPerfectNumber(int num) {
            if (num == 1) {
                return false;
            }
            int sum = 1; // every num is divisble by 1
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    if (num / i == i) { // for perfect sqrs like 5 * 5 = 25 for this we have to add only 5
                        sum += i;
                    } else {
                        sum += i + (num / i);
                    }
                }
            }
            return sum == num;
        }
    }
}
