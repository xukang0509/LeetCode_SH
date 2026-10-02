package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 找到字符串中所有字母异位词
 * @author: xu
 * @date: 2026-10-02 17:38:07
 */
@SuppressWarnings("all")
class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        // TO TEST
        solution.findAnagrams("cbaebabacd", "abc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        final int[] count = new int[26];
        final StringBuilder builder = new StringBuilder();

        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            String pKey = findStr(p.toCharArray());
            int pLen = p.length();
            int left = 0;
            int right = left + pLen;
            char[] sCharArray = s.toCharArray();
            char[] tmp = new char[pLen];
            while (right <= s.length()) {
                System.arraycopy(sCharArray, left, tmp, 0, pLen);
                String tmpStr = findStr(tmp);
                if (tmpStr.equals(pKey)) {
                    res.add(left);
                }
                left++;
                right = left + pLen;
            }
            return res;
        }

        private String findStr(char[] chars) {
            for (char aChar : chars) {
                count[aChar - 'a']++;
            }
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    builder.append((char) ('a' + i)).append(count[i]);
                    count[i] = 0;
                }
            }
            String string = builder.toString();
            builder.setLength(0);
            return string;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}