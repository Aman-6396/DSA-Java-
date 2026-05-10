import java.util.ArrayList;
import java.util.List;

public class Find_All_Duplicates_in_an_Array_Leetcode_442 {
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> ll = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int idx = Math.abs(nums[i]) - 1;
                if (nums[idx] > 0) {
                    nums[idx] = -nums[idx];
                } else { // nums[idx] < 0
                    ll.add(nums[idx]);
                }
            }
            return ll;
        }
    }
}
