import java.util.ArrayList;
import java.util.List;

public class Find_All_Groups_of_Farmland_Leetcode_1992 {
    class Solution {
        public int[][] findFarmland(int[][] land) {
            List<int[]> ll = new ArrayList<>();
            for (int i = 0; i < land.length; i++) {
                for (int j = 0; j < land[0].length; j++) {
                    if (land[i][j] == 1) {
                        int r = i + 1;
                        int c = j + 1;
                        while (r < land.length && land[r][j] == 1) {
                            r++;
                        }
                        while (c < land[0].length && land[i][c] == 1) {
                            c++;
                        }
                        ll.add(new int[] { i, j, r - 1, c - 1 });

                        // mark all the 1 as visited
                        for (int k = i; k < r; k++) {
                            for (int l = j; l < c; l++) {
                                land[k][l] = 0;
                            }
                        }
                    }
                }
            }
            int[][] ans = new int[ll.size()][4];
            for (int i = 0; i < ll.size(); i++) {
                for (int j = 0; j < 4; j++) {
                    int[] arr = ll.get(i);
                    ans[i][j] = arr[j];
                }
            }
            return ans;
        }
    }
}
