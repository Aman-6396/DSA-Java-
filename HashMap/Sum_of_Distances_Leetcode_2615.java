import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sum_of_Distances_Leetcode_2615 {

    // Brute Force Approach Time Complexiyt is O(n^2) & it gives TLE
    // class Solution {
    // public long[] distance(int[] nums) {
    // HashMap<Integer, List<Integer>> map = new HashMap<>();
    // long[] ans = new long[nums.length];

    // // add values in map
    // for (int i = 0; i < nums.length; i++) {
    // if (map.containsKey(nums[i])) {
    // List<Integer> ll = map.get(nums[i]);
    // ll.add(i);
    // map.put(nums[i], ll);
    // } else {
    // List<Integer> ll = new ArrayList<>();
    // ll.add(i);
    // map.put(nums[i], ll);
    // }
    // }

    // for (int i = 0; i < nums.length; i++) {
    // long sum = 0;
    // if (map.get(nums[i]).size() > 1) {
    // List<Integer> ll = map.get(nums[i]);
    // for (int j = 0; j < ll.size(); j++) {
    // int idx = ll.get(j);
    // if (idx != i) {
    // sum += Math.abs(i - idx);
    // }
    // }
    // }
    // ans[i] = sum;
    // }

    // return ans;
    // }
    // }

    // Use prefix concept to calculate difference - Time complexity is O(n)
    class Solution {
        public long[] distance(int[] nums) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            long[] ans = new long[nums.length];

            // add values in map
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    List<Integer> ll = map.get(nums[i]);
                    ll.add(i);
                    map.put(nums[i], ll);
                } else {
                    List<Integer> ll = new ArrayList<>();
                    ll.add(i);
                    map.put(nums[i], ll);
                }
            }

            for (List<Integer> list : map.values()) {
                int size = list.size();
                long[] prefix = new long[size];

                prefix[0] = list.get(0);
                for (int i = 1; i < size; i++) {
                    prefix[i] = prefix[i - 1] + list.get(i);
                }

                for (int i = 0; i < size; i++) {
                    int idx = list.get(i);

                    long left = (i > 0) ? (long) i * idx - prefix[i - 1] : 0;
                    long right = (i < size - 1) ? (prefix[size - 1] - prefix[i]) - (long) (size - 1 - i) * idx : 0;
                    ans[idx] = left + right;
                }
            }

            return ans;
        }
    }
}
