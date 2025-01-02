package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 2024-08-12 20:17:26
 */
@SuppressWarnings("all")
class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String>[] result = new ArrayList[n + 1];
            result[0] = new ArrayList<>(List.of(""));
            result[1] = new ArrayList<>(List.of("()"));
            for (int i = 2; i <= n; i++) {
                result[i] = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    for (String k1 : result[j]) {
                        for (String k2 : result[i - 1 - j]) {
                            result[i].add("(" + k1 + ")" + k2);
                        }
                    }
                }
            }
            return result[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}