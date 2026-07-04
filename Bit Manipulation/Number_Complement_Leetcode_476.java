public class Number_Complement_Leetcode_476 {
    class Solution {
        public int findComplement(int num) {
            int noOfbits = Integer.toBinaryString(num).length();
            int n = (1 << noOfbits) - 1; // it gives no. whose all bits are 1 with same noOfbits as in num
            return num ^ n;
        }
    }
}
