package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效的括号
 * 2024-06-03 10:50:51
 */
@SuppressWarnings("ALL")
class ValidParentheses {
    public static void main(String[] args) {
        Solution s = new ValidParentheses().new Solution();
        System.out.println(s.isValid("()"));
        System.out.println(s.isValid("([{}])"));
        System.out.println(s.isValid("()[]{}"));
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
        private static final Map<Character, Character> MAP = new HashMap<>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};

        public boolean isValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                if (MAP.containsKey(c)) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) return false;
                    char left = stack.pop();
                    if (c != MAP.get(left)) return false;
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}