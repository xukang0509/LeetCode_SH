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
            int hi = 0, delta = hLen - pLen;
            while (hi <= delta) {
                int pi = 0;
                for (; pi < pLen; pi++) {
                    if (haystack.charAt(hi + pi) != pattern.charAt(pi)) break;
                }
                if (pi == pLen) return hi;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}