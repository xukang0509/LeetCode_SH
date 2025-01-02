package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 最常见的单词
 * 2024-07-15 15:33:22
 */
class MostCommonWord {
    public static void main(String[] args) {
        Solution solution = new MostCommonWord().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            Set<String> bannedSet = Set.of(banned);
            Map<String, Integer> map = new HashMap<>();
            char[] chars = paragraph.toLowerCase().toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                if (c >= 'a' && c <= 'z') {
                    sb.append(c);
                } else {
                    put(bannedSet, sb.toString(), map);
                    sb.setLength(0);
                }
            }
            put(bannedSet, sb.toString(), map);

            Integer max = Integer.MIN_VALUE;
            String maxStr = null;
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                if (e.getValue() > max) {
                    max = e.getValue();
                    maxStr = e.getKey();
                }
            }
            return maxStr;
        }

        private static void put(Set<String> bannedSet, String key, Map<String, Integer> map) {
            if (key.isEmpty() || bannedSet.contains(key)) return;
            map.compute(key, (k, v) -> v == null ? 1 : v + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}