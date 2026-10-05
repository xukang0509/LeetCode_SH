package leetcode.editor.cn;

/**
 * @Description: 找不同
 * @author: xu
 * @date: 2026-10-05 14:09:27
 */
@SuppressWarnings("all")
class FindTheDifference {
    public static void main(String[] args) {
        Solution solution = new FindTheDifference().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char findTheDifference(String s, String t) {
            int res = 0;
            for (char c : s.toCharArray()) {
                res ^= c;
            }
            for (char c : t.toCharArray()) {
                res ^= c;
            }
            return (char) res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}