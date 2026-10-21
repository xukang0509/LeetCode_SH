package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 逆波兰表达式求值
 * 2024-06-03 11:46:50
 */
@SuppressWarnings("ALL")
class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        Solution solution = new EvaluateReversePolishNotation().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final Set<String> SET = new HashSet<>() {{
            add("+");
            add("-");
            add("*");
            add("/");
        }};

        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (String token : tokens) {
                if (SET.contains(token)) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    switch (token) {
                        case "+":
                            stack.push(num1 + num2);
                            break;
                        case "-":
                            stack.push(num2 - num1);
                            break;
                        case "*":
                            stack.push(num1 * num2);
                            break;
                        case "/":
                            stack.push(num2 / num1);
                            break;
                    }
                } else {
                    stack.push(Integer.valueOf(token));
                }
            }
            return stack.pop();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}