import java.util.ArrayList;
import java.util.List;

public class Reshape_the_Matrix_Leetcode_566 {
    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            if (mat.length * mat[0].length != r * c) { // reshape is not possible
                return mat;
            }

            List<Integer> ll = new ArrayList<>();
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    ll.add(mat[i][j]);
                }
            }
            int[][] ans = new int[r][c];
            int idx = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    ans[i][j] = ll.get(idx);
                    idx++;
                }
            }
            return ans;
        }
    }
}
