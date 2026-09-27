package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 反转字符串
 * 2024-08-19 22:28:28
 */
@SuppressWarnings("all")
class ReverseString {
    public static void main(String[] args) {
        Solution solution = new ReverseString().new Solution();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("s = " + Arrays.toString(s));
        solution.reverseString(s);
        System.out.println("s = " + Arrays.toString(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            reverseString(s, 0, s.length - 1);
        }

        private static void reverseString(char[] s, int left, int right) {
            while (left < right) {
                swap(s, left++, right--);
            }
        }

        private static void swap(char[] s, int i, int j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}