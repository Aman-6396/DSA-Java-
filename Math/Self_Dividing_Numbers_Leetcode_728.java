import java.util.ArrayList;
import java.util.List;

public class Self_Dividing_Numbers_Leetcode_728 {
    class Solution {
        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> ll = new ArrayList<>();
            for (int i = left; i <= right; i++) {
                int n = i;
                boolean isSelfDiv = true;
                while (n > 0) {
                    int rem = n % 10;
                    n = n / 10;
                    if (rem == 0 || i % rem != 0) {
                        isSelfDiv = false;
                        break;
                    }
                }
                if (isSelfDiv) {
                    ll.add(i);
                }
            }
            return ll;
        }
    }
}
