import java.util.Arrays;

public class Sort_the_People_Leetcode2418 {
    // Brute Force Approach with Time complexity O(N^2)
    // class Solution {
    // public String[] sortPeople(String[] names, int[] heights) {
    // for (int i = 0; i < heights.length - 1; i++) {
    // int maxIdx = i;
    // for (int j = i + 1; j < heights.length; j++) {
    // if (heights[j] > heights[maxIdx]) {
    // maxIdx = j;
    // }
    // }
    // // swap max val with ith index value
    // int temp1 = heights[maxIdx];
    // heights[maxIdx] = heights[i];
    // heights[i] = temp1;

    // // same swapping for String array
    // String temp2 = names[maxIdx];
    // names[maxIdx] = names[i];
    // names[i] = temp2;
    // }

    // return names;
    // }
    // }

    // Optimized Approach using Comparator
    class Solution {
        public String[] sortPeople(String[] names, int[] heights) {
            Integer[] arr = new Integer[heights.length];
            for (int i = 0; i < heights.length; i++) {
                arr[i] = i;
            }

            Arrays.sort(arr, (a, b) -> heights[b] - heights[a]);

            String[] ans = new String[names.length];
            for (int i = 0; i < arr.length; i++) {
                ans[i] = names[arr[i]];
            }

            return ans;
        }
    }

}
