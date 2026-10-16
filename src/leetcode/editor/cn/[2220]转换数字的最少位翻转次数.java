package leetcode.editor.cn;

/**
 * @Description: 转换数字的最少位翻转次数
 * @author: xu
 * @date: 2026-10-16 22:51:43
 */
@SuppressWarnings("all")
class MinimumBitFlipsToConvertNumber {
    public static void main(String[] args) {
        Solution solution = new MinimumBitFlipsToConvertNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minBitFlips(int start, int goal) {
            int i = start ^ goal;
            int res = 0;
            while (i != 0) {
                i &= i - 1;
                res++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}