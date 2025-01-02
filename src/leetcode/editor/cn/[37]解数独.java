package leetcode.editor.cn;

/**
 * 解数独
 * 2024-08-17 11:28:39
 */
@SuppressWarnings("all")
class SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new SudokuSolver().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solveSudoku(char[][] board) {
            int n = 9;
            boolean[][] rowNum = new boolean[n][n];
            boolean[][] colNum = new boolean[n][n];
            boolean[][][] nineBlocksNum = new boolean[3][3][n];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        int x = board[i][j] - '1';
                        rowNum[i][x] = true;
                        colNum[x][j] = true;
                        nineBlocksNum[i / 3][j / 3][x] = true;
                    }
                }
            }
            dfs(board, 0, 0, rowNum, colNum, nineBlocksNum);
        }

        private boolean dfs(char[][] board, int row, int col,
                            boolean[][] rowNum, boolean[][] colNum,
                            boolean[][][] nineBlocksNum) {
            while (board[row][col] != '.') {
                if (++col >= 9) {
                    col = 0;
                    row++;
                }
                if (row >= 9) {
                    return true;
                }
            }
            int n = board.length;
            for (int d = 0; d < n; d++) {
                if (rowNum[row][d] || colNum[d][col] || nineBlocksNum[row / 3][col / 3][d]) {
                    continue;
                }
                char ch = (char) (d + '1');
                board[row][col] = ch;
                rowNum[row][d] = colNum[d][col] = nineBlocksNum[row / 3][col / 3][d] = true;
                if (dfs(board, row, col, rowNum, colNum, nineBlocksNum)) {
                    return true;
                }
                rowNum[row][d] = colNum[d][col] = nineBlocksNum[row / 3][col / 3][d] = false;
                board[row][col] = '.';
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}