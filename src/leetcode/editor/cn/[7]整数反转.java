package leetcode.editor.cn;

/**
 * 整数反转
 *
 * @author xk
 * @date 2026-09-24 16:27:19
 */
@SuppressWarnings("all")
class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        // TO TEST
        System.out.println("solution.reverse(123) = " + solution.reverse(123));
        System.out.println("solution.reverse(120) = " + solution.reverse(120));
        System.out.println("solution.reverse(-123) = " + solution.reverse(-123));
        System.out.println("solution.reverse(1534236469) = " + solution.reverse(1534236469));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int reverse(int x) {
           /* int num = Math.abs(x);
            while (num != 0) {
                int tmp = num % 10;
                num /= 10;
                deque.push(tmp);
            }

            return x < 0 ? -res : res;*/
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}