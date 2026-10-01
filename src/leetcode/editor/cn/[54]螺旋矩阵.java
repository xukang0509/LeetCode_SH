package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 螺旋矩阵
 * @author: xu
 * @date: 2026-10-01 15:14:14
 */
@SuppressWarnings("all")
class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        // TO TEST
        solution.spiralOrder(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            List<Integer> res = new ArrayList<>(m * n);
            boolean[][] isVisited = new boolean[m][n];
            int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int total = m * n;
            int row = 0, column = 0, direIndex = 0;
            for (int i = 0; i < total; i++) {
                res.add(matrix[row][column]);
                isVisited[row][column] = true;
                int nextRow = row + direction[direIndex][0], nextColumn = column + direction[direIndex][1];
                if (nextRow < 0 || nextRow >= m || nextColumn < 0 || nextColumn >= n || isVisited[nextRow][nextColumn]) {
                    direIndex = (direIndex + 1) % 4;
                }
                row += direction[direIndex][0];
                column += direction[direIndex][1];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}