package leetcode.editor.cn;

/**
 * @Description: 交替位二进制数
 * @author: xu
 * @date: 2026-10-05 17:44:23
 */
@SuppressWarnings("all")
class BinaryNumberWithAlternatingBits {
    public static void main(String[] args) {
        Solution solution = new BinaryNumberWithAlternatingBits().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean hasAlternatingBits(int n) {
            n ^= n >>> 1;
            return (n & (n + 1)) == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}