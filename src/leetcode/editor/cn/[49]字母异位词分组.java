package leetcode.editor.cn;

import java.util.*;

/**
 * 字母异位词分组
 * 2024-07-15 14:21:16
 */
class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<ArrayKey, List<String>> map = new HashMap<>();
            for (String str : strs) {
                ArrayKey key = new ArrayKey(str);
                List<String> stringList = map.computeIfAbsent(key, k -> new ArrayList<>());
                stringList.add(str);
            }
            return new ArrayList<>(map.values());
        }

        static class ArrayKey {
            int[] array = new int[26];

            public ArrayKey(String str) {
                for (char c : str.toCharArray()) {
                    array[c - 'a']++;
                }
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof ArrayKey arrayKey)) return false;
                return Arrays.equals(array, arrayKey.array);
            }

            @Override
            public int hashCode() {
                return Arrays.hashCode(array);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}