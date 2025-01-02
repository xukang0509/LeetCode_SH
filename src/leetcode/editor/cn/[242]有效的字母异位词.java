package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 有效的字母异位词
 * 2024-07-15 14:48:01
 */
class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            return Arrays.equals(getKey(s), getKey(t));
        }

        private char[] getKey(String str) {
            char[] chars = new char[26];
            for (char c : str.toCharArray()) {
                chars[c - 'a']++;
            }
            return chars;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}