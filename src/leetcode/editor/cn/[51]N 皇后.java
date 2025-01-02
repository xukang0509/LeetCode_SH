package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N 皇后
 * 2024-08-17 10:07:28
 */
@SuppressWarnings("all")
class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();
            char[][] table = new char[n][n];
            boolean[] bcol = new boolean[n];
            boolean[] blu = new boolean[2 * n + 1];
            boolean[] bru = new boolean[2 * n + 1];
            for (int i = 0; i < table.length; i++) {
                Arrays.fill(table[i], '.');
            }
            dfs(0, n, table, result, bcol, blu, bru);
            return result;
        }

        private void dfs(int row, int n, char[][] table, List<List<String>> result, boolean[] bcol, boolean[] blu, boolean[] bru) {
            if (row == n) {
                List<String> list = new ArrayList<>();
                for (char[] chars : table) {
                    list.add(String.valueOf(chars));
                }
                result.add(list);
                return;
            }
            for (int col = 0; col < n; col++) {
                if (bcol[col] || bru[row + col] || blu[row - col + n - 1]) continue;
                bcol[col] = bru[row + col] = blu[row - col + n - 1] = true;
                table[row][col] = 'Q';
                dfs(row + 1, n, table, result, bcol, blu, bru);
                table[row][col] = '.';
                bcol[col] = bru[row + col] = blu[row - col + n - 1] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}