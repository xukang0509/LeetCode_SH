package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 有效的括号
 * 2024-06-03 10:50:51
 */
class ValidParentheses {
    public static void main(String[] args) {
        Solution s = new ValidParentheses().new Solution();
        System.out.println(s.isValid("([{}])"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("()"));
        System.out.println("---------------------");

        System.out.println(s.isValid("[)"));
        // ]
        System.out.println(s.isValid("([)]"));
        // ) ]
        System.out.println(s.isValid("([]"));
        // )
        System.out.println(s.isValid("("));

        System.out.println("---------------------");
        System.out.println(s.isValid(")("));
        System.out.println(s.isValid("]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) return false;
                    switch (c) {
                        case ')' -> {
                            if (stack.pop() != '(') return false;
                        }
                        case ']' -> {
                            if (stack.pop() != '[') return false;
                        }
                        case '}' -> {
                            if (stack.pop() != '{') return false;
                        }
                    }
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}