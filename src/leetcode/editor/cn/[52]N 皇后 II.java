package leetcode.editor.cn;

import java.util.Arrays;

/**
 * N 皇后 II
 * 2024-08-17 10:07:37
 */
@SuppressWarnings("all")
class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
        for (int i = 1; i <= 9; i++) {
            System.out.println("totalNQueues(" + i + ") = " + solution.totalNQueens(i));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalNQueens(int n) {
            char[][] table = new char[n][n];
            boolean[] bcol = new boolean[n];
            boolean[] blu = new boolean[2 * n + 1];
            boolean[] bru = new boolean[2 * n + 1];
            for (int i = 0; i < table.length; i++) {
                Arrays.fill(table[i], '.');
            }
            return dfs(0, n, table, bcol, blu, bru);
        }

        private int dfs(int row, int n, char[][] table, boolean[] bcol, boolean[] blu, boolean[] bru) {
            if (row == n) {
                return 1;
            }
            int result = 0;
            for (int col = 0; col < n; col++) {
                if (bcol[col] || bru[row + col] || blu[row - col + n - 1]) continue;
                bcol[col] = bru[row + col] = blu[row - col + n - 1] = true;
                table[row][col] = 'Q';
                result += dfs(row + 1, n, table, bcol, blu, bru);
                table[row][col] = '.';
                bcol[col] = bru[row + col] = blu[row - col + n - 1] = false;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}