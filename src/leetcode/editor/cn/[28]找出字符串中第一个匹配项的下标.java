package leetcode.editor.cn;

/**
 * 找出字符串中第一个匹配项的下标
 * 2024-08-22 22:14:41
 */
@SuppressWarnings("all")
class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
        solution.strStr("aaa", "aaa");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String pattern) {
            if (haystack == null || pattern == null) return -1;
            int hLen = haystack.length(), pLen = pattern.length();
            if (hLen == 0 || pLen == 0 || hLen < pLen) return -1;

            int[] next = getNext(pattern.toCharArray());
            int hi = 0, pi = 0;
            while (pi < pLen && hi < hLen) {
                if (pi < 0 || haystack.charAt(hi) == pattern.charAt(pi)) {
                    hi++;
                    pi++;
                } else {
                    pi = next[pi];
                }
            }
            return pi == pLen ? (hi - pi) : -1;
        }

        private static int[] getNext(char[] pattern) {
            int[] next = new int[pattern.length];
            int n = next[0] = -1;
            int i = 0, iMax = pattern.length - 1;
            while (i < iMax) {
                if (n < 0 || pattern[i] == pattern[n]) {
                    next[++i] = ++n;
                } else {
                    n = next[n];
                }
            }
            return next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}