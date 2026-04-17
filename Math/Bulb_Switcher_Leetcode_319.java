//import java.util.Arrays;

public class Bulb_Switcher_Leetcode_319 {
    // Time Complexity = O(n^2)
    // class Solution {
    // public int bulbSwitch(int n) {
    // int[] arr = new int[n];
    // if (n == 0) {
    // return 0;
    // }
    // if (n == 1) {
    // return 1;
    // }
    // Arrays.fill(arr, 1);
    // for (int i = 2; i <= n; i++) {
    // for (int j = 0; j <= n; j += i) {
    // int val = arr[j];
    // if (val == 1) {
    // arr[j] = 0;
    // } else { // val == 0
    // arr[j] = 1;
    // }
    // }
    // }

    // int count = 0;
    // for (int i = 0; i <= n; i++) {
    // if (arr[i] == 1) {
    // count++;
    // }
    // }

    // return count;
    // }
    // }

    // Time Complexity = O(1)
    class Solution {
        public int bulbSwitch(int n) {
            return (int) Math.sqrt(n);
        }
    }
}
