package leetcode.editor.cn;

/**
 * 字符串中的第一个唯一字符
 * 2024-07-15 15:26:17
 */
class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            int[] arr = new int[26];
            char[] chars = s.toCharArray();
            for (char c : chars) {
                arr[c - 'a']++;
            }
            for (int i = 0; i < chars.length; i++) {
                if (arr[chars[i] - 'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}