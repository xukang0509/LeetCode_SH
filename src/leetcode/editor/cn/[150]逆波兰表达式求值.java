package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 逆波兰表达式求值
 * 2024-06-03 11:46:50
 */
class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        Solution solution = new EvaluateReversePolishNotation().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> numsStack = new LinkedList<>();
            for (String token : tokens) {
                switch (token) {
                    case "+" -> {
                        Integer num1 = numsStack.pop();
                        Integer num2 = numsStack.pop();
                        numsStack.push(num1 + num2);
                    }
                    case "-" -> {
                        Integer num1 = numsStack.pop();
                        Integer num2 = numsStack.pop();
                        numsStack.push(num2 - num1);
                    }
                    case "*" -> {
                        Integer num1 = numsStack.pop();
                        Integer num2 = numsStack.pop();
                        numsStack.push(num1 * num2);
                    }
                    case "/" -> {
                        Integer num1 = numsStack.pop();
                        Integer num2 = numsStack.pop();
                        numsStack.push(num2 / num1);
                    }
                    default -> numsStack.push(Integer.parseInt(token));
                }
            }
            return numsStack.pop();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}