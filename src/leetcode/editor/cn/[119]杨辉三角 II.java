package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 * 2024-06-01 09:18:45
 */
class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int i = 1; i <= rowIndex; i++) {
                row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
            }
            return row;
        }


        public List<Integer> getRow1(int rowIndex) {
            return generate(rowIndex + 1).get(rowIndex);
        }

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> col = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || i == j) {
                        col.add(1);
                    } else {
                        col.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                    }
                }
                result.add(col);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}