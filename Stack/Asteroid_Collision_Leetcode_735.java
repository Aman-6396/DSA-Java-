import java.util.Stack;

public class Asteroid_Collision_Leetcode_735 {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < asteroids.length; i++) {
                if (asteroids[i] > 0) { // positive
                    st.push(asteroids[i]);
                } else { // negative
                    while (!st.isEmpty() && st.peek() > 0 && Math.abs(st.peek()) < Math.abs(asteroids[i])) {
                        System.out.println(st.peek());
                        st.pop();
                    }
                    if (!st.isEmpty() && st.peek() > 0 && Math.abs(st.peek()) > Math.abs(asteroids[i])) {
                        System.out.println("First Continue");
                        continue;
                    } else if (!st.isEmpty() && st.peek() > 0 && Math.abs(asteroids[i]) == Math.abs(asteroids[i])) {
                        st.pop();
                        continue;
                    } else {// negative number then add this in the stack
                        st.push(asteroids[i]);
                    }
                }
            }

            int[] arr = new int[st.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[arr.length - i - 1] = st.pop();
            }
            return arr;
        }
    }
}
