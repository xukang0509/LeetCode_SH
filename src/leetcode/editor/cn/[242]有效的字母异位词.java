package leetcode.editor.cn;

/**
 * 有效的字母异位词
 * 2024-07-15 14:48:01
 */
@SuppressWarnings("ALL")
class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s == null || t == null || s.length() != t.length()) return false;
            int[] count = new int[26];
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();
            for (char c : sChars) {
                count[c - 'a']++;
            }
            for (char c : tChars) {
                count[c - 'a']--;
            }
            for (int num : count) {
                if (num != 0) return false;
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}