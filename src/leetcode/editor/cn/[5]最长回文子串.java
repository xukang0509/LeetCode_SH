package leetcode.editor.cn;

/**
 * 最长回文子串
 * 2024-08-23 22:38:13
 */
@SuppressWarnings("all")
class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static int left;
        private static int right;

        public String longestPalindrome(String s) {
            left = right = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length - 1; i++) {
                // 一个字符作为中心点
                extend(chars, i, i);
                // 两个字符作为中心点
                extend(chars, i, i + 1);
            }
            return new String(chars, left, right - left + 1);
        }

        private void extend(char[] chars, int i, int j) {
            // 如果是回文，扩大回文范围
            while (i >= 0 && j < chars.length && chars[i] == chars[j]) {
                i--;
                j++;
            }
            // 退出循环时，i和j指向的不是回文，需要还原
            i++;
            j--;
            if (j - i > right - left) {
                left = i;
                right = j;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}