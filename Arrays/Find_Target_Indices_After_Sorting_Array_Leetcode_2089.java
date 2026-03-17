import java.util.ArrayList;
import java.util.List;

public class Find_Target_Indices_After_Sorting_Array_Leetcode_2089 {

    class Solution {
        public List<Integer> targetIndices(int[] nums, int target) {

            List<Integer> ll = new ArrayList<>();
            int noOfMinVal = 0;
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    count++;
                }
                if (nums[i] < target) {
                    noOfMinVal++;
                }
            }

            for (int i = noOfMinVal; i < noOfMinVal + count; i++) {
                ll.add(i);
            }

            return ll;

        }
    }

}
