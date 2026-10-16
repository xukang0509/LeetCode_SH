package leetcode.editor.cn;

/**
 * @Description: 旋转字符串
 * @author: xu
 * @date: 2026-10-08 19:43:10
 */
@SuppressWarnings("all")
class RotateString {
    public static void main(String[] args) {
        Solution solution = new RotateString().new Solution();
        // TO TEST
        solution.rotateString("bewzpm", "ewzpmb");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean rotateString(String s, String goal) {
            if (s.length() != goal.length()) return false;

            char[] sCharArr = s.toCharArray();
            char[] gCharArr = goal.toCharArray();

            int length = sCharArr.length;
            for (int i = 0; i < length; i++) {
                int j = i;
                while (j < i + length) {
                    if (sCharArr[j < length ? j : j - length] == gCharArr[j - i]) {
                        j++;
                    } else {
                        break;
                    }
                }
                if (j == i + length) return true;
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}