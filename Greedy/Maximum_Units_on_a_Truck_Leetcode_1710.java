import java.util.Arrays;

public class Maximum_Units_on_a_Truck_Leetcode_1710 {
    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
            int sum = 0;
            for (int i = 0; i < boxTypes.length; i++) {
                System.out.println(Arrays.toString(boxTypes[i]));
            }

            for (int i = 0; i < boxTypes.length; i++) {
                if (truckSize > 0 && truckSize >= boxTypes[i][0]) {
                    sum += boxTypes[i][1] * boxTypes[i][0];
                    truckSize -= boxTypes[i][0];
                } else if (truckSize > 0 && truckSize < boxTypes[i][0]) {
                    sum += boxTypes[i][1] * truckSize;
                    truckSize = 0;
                }
                if (truckSize == 0) {
                    break;
                }
            }
            return sum;
        }
    }
}
