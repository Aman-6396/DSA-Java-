public class Number_of_Employees_Who_Met_the_Target_Leetcode_2798 {
    class Solution {
        public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
            int ans = 0;
            for (int i = 0; i < hours.length; i++) {
                if (hours[i] >= target) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
