package leetcode.editor.cn;

/**
 * 有效的完全平方数
 *
 * @author xk
 * @date 2026-09-25 21:38:48
 */
@SuppressWarnings("all")
class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            int left = 1, right = num;
            while (left <= right) {
                int mid = left + ((right - left) >>> 1);
                long square = (long) mid * mid;
                if (square > num) {
                    right = mid - 1;
                } else if (square < num) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}