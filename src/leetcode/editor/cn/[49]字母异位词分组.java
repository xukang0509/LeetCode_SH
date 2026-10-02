package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 字母异位词分组
 * 2024-07-15 14:21:16
 */
@SuppressWarnings("ALL")
class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            final StringBuilder builder = new StringBuilder();
            final int[] count = new int[26];
            return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
                for (int i = 0; i < str.length(); i++) {
                    count[str.charAt(i) - 'a']++;
                }
                for (int i = 0; i < count.length; i++) {
                    if (count[i] != 0) {
                        builder.append(((char) ('a' + i))).append(count[i]);
                        count[i] = 0;
                    }
                }
                String key = builder.toString();
                builder.setLength(0);
                return key;
            })).values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}