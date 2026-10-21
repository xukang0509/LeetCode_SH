package leetcode.editor.cn;

/**
 * @Description: 删除字符串中的所有相邻重复项
 * @author: xu
 * @date: 2026-10-17 16:50:00
 */
@SuppressWarnings("all")
class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        Solution solution = new RemoveAllAdjacentDuplicatesInString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicates(String s) {
            StringBuilder stack = new StringBuilder(s.length());
            int top = -1;
            char c;
            for (int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                if (top >= 0 && c == stack.charAt(top)) {
                    stack.deleteCharAt(top);
                    top--;
                } else {
                    stack.append(c);
                    top++;
                }
            }
            return stack.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}