import java.util.ArrayList;
import java.util.List;

public class Build_an_Array_With_Stack_Operations_Leetcode_1441 {
    class Solution {
        public List<String> buildArray(int[] target, int n) {
            List<String> ll = new ArrayList<>();
            int idx = 0;
            int i = 1;
            while (i <= n && idx < target.length) {
                ll.add("Push");
                if (target[idx] != i) {
                    ll.add("Pop");
                } else {
                    idx++;
                }
                i++;
            }
            return ll;
        }
    }
}
