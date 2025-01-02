package leetcode.editor.cn;

/**
 * Pow(x, n)
 * 2024-08-13 10:32:10
 */
@SuppressWarnings("all")
class PowxN {
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (n == 0) return 1;
            if (n == 1) return x;
            double res = 1;
            long N = n;
            if (N < 0) N = -N;
            while (N > 0) {
                if ((N & 1) == 1) {
                    res *= x;
                }
                x = x * x;
                N >>= 1;
            }
            return n > 0 ? res : 1.0 / res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}