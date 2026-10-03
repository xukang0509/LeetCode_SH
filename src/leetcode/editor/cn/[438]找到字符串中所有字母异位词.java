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

        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            int sLen = s.length();
            int pLen = p.length();
            if (sLen < pLen) return res;
            int[] count = new int[26];
            for (int i = 0; i < pLen; i++) {
                count[s.charAt(i) - 'a']++;
                count[p.charAt(i) - 'a']--;
            }
            int differ = 0;
            for (int num : count) {
                if (num != 0) differ++;
            }
            if (differ == 0) res.add(0);
            for (int i = 0; i < sLen - pLen; i++) {
                if (count[s.charAt(i) - 'a'] == 1) {
                    differ--;
                } else if (count[s.charAt(i) - 'a'] == 0) {
                    differ++;
                }
                count[s.charAt(i) - 'a']--;

                if (count[s.charAt(i + pLen) - 'a'] == -1) {
                    differ--;
                } else if (count[s.charAt(i + pLen) - 'a'] == 0) {
                    differ++;
                }
                count[s.charAt(i + pLen) - 'a']++;

                if (differ == 0) res.add(i + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}