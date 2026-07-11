
//import java.util.HashSet;
import java.util.List;

public class Minimum_Operations_to_Collect_Elements_Leetcode_2869 {
    // class Solution {
    // public int minOperations(List<Integer> nums, int k) {
    // HashSet<Integer> set = new HashSet<>();
    // int last = nums.size();
    // for (int i = nums.size() - 1; i >= 0; i--) {
    // if (nums.get(i) <= k && !set.contains(nums.get(i))) {
    // set.add(nums.get(i));
    // last = i;
    // }
    // }
    // return nums.size() - last;
    // }

    // }

    class Solution {
        public int minOperations(List<Integer> nums, int k) {
            boolean[] arr = new boolean[k + 1];
            int count = 0;
            for (int i = nums.size() - 1; i >= 0; i--) {
                if (nums.get(i) <= k && arr[nums.get(i)] == false) {
                    arr[nums.get(i)] = true;
                    count++;
                }

                if (count == k) {
                    return nums.size() - i;
                }
            }
            return -1; // never returns
        }
    }
}
