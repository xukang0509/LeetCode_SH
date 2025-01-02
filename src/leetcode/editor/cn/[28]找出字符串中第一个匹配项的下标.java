package leetcode.editor.cn;

/**
 * 找出字符串中第一个匹配项的下标
 * 2024-08-22 22:14:41
 */
@SuppressWarnings("all")
class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String text, String pattern) {
            char[] textChars = text.toCharArray();
            char[] patternChars = pattern.toCharArray();
            int plen = patternChars.length, tlen = textChars.length;

            int[] next = next(pattern);
            int pi = 0, ti = 0, lenDelta = tlen - plen;
            while (pi < plen && (ti - pi) <= lenDelta) {
                if (pi < 0 || textChars[ti] == patternChars[pi]) {
                    pi++;
                    ti++;
                } else {
                    pi = next[pi];
                }
            }
            return pi == plen ? (ti - pi) : -1;
        }

        private int[] next(String pattern) {
            char[] chars = pattern.toCharArray();
            int[] next = new int[chars.length];
            int n = next[0] = -1;
            int i = 0, iMax = chars.length - 1;
            while (i < iMax) {
                if (n < 0 || chars[i] == chars[n]) {
                    next[++i] = ++n;
                    if (chars[i] == chars[n]) {
                        next[i] = next[n];
                    } else {
                        next[i] = n;
                    }
                } else {
                    n = next[n];
                }
            }
            return next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}