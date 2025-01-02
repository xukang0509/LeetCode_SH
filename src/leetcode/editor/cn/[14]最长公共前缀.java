package leetcode.editor.cn;

/**
 * 最长公共前缀
 * 2024-08-23 22:28:24
 */
@SuppressWarnings("all")
class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            char[] first = strs[0].toCharArray();
            for (int i = 0; i < first.length; i++) {
                char ch = first[i];
                for (int j = 1; j < strs.length; j++) {
                    if (i == strs[j].length() || ch != strs[j].charAt(i)) {
                        return new String(first, 0, i);
                    }
                }
            }
            return strs[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}