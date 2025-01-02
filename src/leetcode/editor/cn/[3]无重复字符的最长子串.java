package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 无重复字符的最长子串
 * 2024-07-15 13:54:23
 */
class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int[] array = new int[128];
            Arrays.fill(array, -1);
            int begin = 0;
            int maxLength = 0;
            for (int end = 0; end < s.length(); end++) {
                char c = s.charAt(end);
                if (array[c] != -1) { // 重复时调整 begin
                    begin = Math.max(begin, array[c] + 1);
                }
                array[c] = end;
                maxLength = Math.max(maxLength, end - begin + 1);
            }
            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}