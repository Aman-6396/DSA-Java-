import java.util.Stack;

public class Count_Collisions_on_a_Road_Leetcode_2211 {
    // By Stack with Time complexity is O(N)
    class Solution {
        public int countCollisions(String directions) {
            Stack<Integer> st = new Stack<>();
            StringBuilder sb = new StringBuilder(directions);
            int count = 0;
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == 'R') {
                    st.push(i); // push index of 'R'
                } else if (sb.charAt(i) == 'S') {
                    while (!st.isEmpty() && sb.charAt(st.peek()) == 'R') {
                        count++;
                        st.pop();
                    }
                    st.push(i); // push index of 'S'
                } else { // sb.charAt(i) == 'L'
                    if (!st.isEmpty() && sb.charAt(st.peek()) == 'R') {
                        count += 2;
                        sb.setCharAt(st.peek(), 'S');
                        int idx = st.peek();
                        st.pop();
                        while (!st.isEmpty() && sb.charAt(st.peek()) == 'R') {
                            count++;
                            st.pop();
                        }
                        st.push(idx); // push index of 'S'
                    } else if (!st.isEmpty() && sb.charAt(st.peek()) == 'S') {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
