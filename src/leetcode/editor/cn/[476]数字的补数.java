package leetcode.editor.cn;

/**
 * @Description: 数字的补数
 * @author: xu
 * @date: 2026-10-05 17:00:33
 */
@SuppressWarnings("all")
class NumberComplement {
    public static void main(String[] args) {
        Solution solution = new NumberComplement().new Solution();
        // TO TEST
        solution.findComplement(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findComplement(int num) {
            int mask = 0, n = num;
            while (n != 0) {
                mask = (mask << 1) | 1;
                n >>>= 1;
            }
            return mask ^ num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}