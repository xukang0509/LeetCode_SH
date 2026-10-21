package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description: 简化路径
 * @author: xu
 * @date: 2026-10-21 21:04:43
 */
@SuppressWarnings("all")
class SimplifyPath {
    public static void main(String[] args) {
        Solution solution = new SimplifyPath().new Solution();
        // TO TEST
        System.out.println("solution.simplifyPath(\"/home/\").equals(\"/home\") = " + solution.simplifyPath("/home/").equals("/home"));
        System.out.println("solution.simplifyPath(\"/home//foo/\").equals(\"/home/foo\") = " + solution.simplifyPath("/home//foo/").equals("/home/foo"));
        System.out.println("solution.simplifyPath(\"/home/user/Documents/../Pictures\").equals(\"/home/user/Pictures\") = " + solution.simplifyPath("/home/user/Documents/../Pictures").equals("/home/user/Pictures"));
        System.out.println("solution.simplifyPath(\"/../\").equals(\"/\") = " + solution.simplifyPath("/../").equals("/"));
        System.out.println("solution.simplifyPath(\"/.../a/../b/c/../d/./\").equals(\"/.../b/d\") = " + solution.simplifyPath("/.../a/../b/c/../d/./").equals("/.../b/d"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String simplifyPath(String path) {
            String[] name = path.split("/");
            Deque<String> deque = new ArrayDeque<>(name.length);
            for (String s : name) {
                if ("..".equals(s)) {
                    if (!deque.isEmpty()) deque.pollLast();
                } else if ("".equals(s) || ".".equals(s)) {
                    continue;
                } else {
                    deque.offerLast(s);
                }
            }
            StringBuilder builder = new StringBuilder();
            while (!deque.isEmpty()) {
                builder.append("/").append(deque.pollFirst());
            }
            return builder.isEmpty() ? "/" : builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}