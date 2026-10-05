package leetcode.editor.cn;

/**
 * @Description: 颠倒二进制位
 * @author: xu
 * @date: 2026-10-05 16:19:22
 */
@SuppressWarnings("all")
class ReverseBits {
    public static void main(String[] args) {
        Solution solution = new ReverseBits().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int M1 = 0x55555555; // 01010101010101010101010101010101
        private static final int M2 = 0x33333333; // 00110011001100110011001100110011
        private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
        private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

        public int reverseBits(int n) {
            n = n >>> 1 & M1 | (n & M1) << 1;
            n = n >>> 2 & M2 | (n & M2) << 2;
            n = n >>> 4 & M4 | (n & M4) << 4;
            n = n >>> 8 & M8 | (n & M8) << 8;
            return n >>> 16 | n << 16;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}