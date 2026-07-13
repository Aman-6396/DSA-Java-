import java.util.HashMap;
import java.util.Stack;

public class Next_Greater_Element_I_Leetcode_496 {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Stack<Integer> st = new Stack<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] ans = new int[nums1.length];
            for (int i = 0; i < nums2.length; i++) {
                while (!st.isEmpty() && st.peek() < nums2[i]) {
                    map.put(st.pop(), nums2[i]);
                }
                st.push(nums2[i]);
            }

            // In last for remaining elements in stack there exists no next greater element
            while (!st.isEmpty()) {
                map.put(st.pop(), -1);
            }

            // Interate on nums1
            for (int i = 0; i < nums1.length; i++) {
                ans[i] = map.get(nums1[i]);
            }
            return ans;
        }
    }
}
