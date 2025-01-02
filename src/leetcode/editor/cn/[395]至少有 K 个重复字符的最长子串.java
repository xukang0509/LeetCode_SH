package leetcode.editor.cn;

/**
 * 至少有 K 个重复字符的最长子串
 * 2024-08-13 14:18:29
 */
@SuppressWarnings("all")
class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
        //System.out.println(solution.longestSubstring("ababbc", 2));
        System.out.println(solution.longestSubstring("dddxaabaaabaacciiiiefbff", 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubstring(String s, int k) {
            if (s.length() < k) return 0;
            char[] chars = s.toCharArray();
            int[] hash = new int[26];
            for (char c : chars) {
                hash[c - 'a']++;
            }
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                int count = hash[aChar - 'a'];
                if (count > 0 && count < k) {
                    int j = i + 1;
                    while (j < s.length() && hash[chars[j] - 'a'] < k) {
                        j++;
                    }
                    return Integer.max(
                            longestSubstring(s.substring(0, i), k),
                            longestSubstring(s.substring(j), k));
                }
            }
            return s.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}