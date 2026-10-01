package leetcode.editor.cn;

/**
 * @Description: 螺旋矩阵 II
 * @author: xu
 * @date: 2026-10-01 14:52:34
 */
@SuppressWarnings("all")
class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] nums = new int[n][n];
            boolean[][] isVisited = new boolean[n][n];
            int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int row = 0, column = 0;
            int total = n * n, count = 1, direIndex = 0;
            for (int i = 0; i < total; i++) {
                nums[row][column] = count++;
                isVisited[row][column] = true;
                int nextRow = row + direction[direIndex][0], nextColumn = column + direction[direIndex][1];
                if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || isVisited[nextRow][nextColumn]) {
                    direIndex = (direIndex + 1) % 4;
                }
                row += direction[direIndex][0];
                column += direction[direIndex][1];
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}