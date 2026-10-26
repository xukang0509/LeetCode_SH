package leetcode.editor.cn;

/**
 * @Description: 191 位1的个数 number-of-1-bits
 * @author: xu
 * @date: 2026-10-25 06:02:35
 */
@SuppressWarnings("all")
class NumberOf1Bits {
    public static void main(String[] args) {
        Solution solution = new NumberOf1Bits().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                n &= (n - 1);
                count++;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}