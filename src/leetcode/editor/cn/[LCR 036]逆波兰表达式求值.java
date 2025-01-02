package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 逆波兰表达式求值
 * 2024-06-03 11:18:23
 */
class EightZf90G {
    public static void main(String[] args) {
        Solution solution = new EightZf90G().new Solution();
        int res = solution.evalRPN(new String[]{"2", "1", "+", "3", "*"});
        System.out.println("res = " + res);
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