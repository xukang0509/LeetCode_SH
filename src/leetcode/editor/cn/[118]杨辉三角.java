package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * 2024-06-01 09:18:43
 */
class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
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