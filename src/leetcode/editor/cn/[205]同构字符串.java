package leetcode.editor.cn;

/**
 * @Description: 同构字符串
 * @author: xu
 * @date: 2026-10-18 11:27:40
 */
@SuppressWarnings("all")
class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings().new Solution();
        // TO TEST
        solution.isIsomorphic("egg", "add");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) return false;
            int[] hash = new int[128];
            boolean[] used = new boolean[128];
            for (int i = 0; i < s.length(); i++) {
                char c1 = s.charAt(i), c2 = t.charAt(i);
                if (hash[c1] != 0) {
                    if (hash[c1] != c2) return false;
                } else if (used[c2]) {
                    return false;
                }
                hash[c1] = c2;
                used[c2] = true;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}