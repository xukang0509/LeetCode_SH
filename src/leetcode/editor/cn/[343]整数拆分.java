package leetcode.editor.cn;

/**
 * 整数拆分
 * 2024-08-08 17:53:05
 */
@SuppressWarnings("all")
class IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new IntegerBreak().new Solution();
        System.out.println(solution.integerBreak(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerBreak(int n) {
            if (n <= 3) return n - 1;
            int a = n / 3, b = n % 3;
            int res;
            if (b == 0) {
                res = (int) Math.pow(3, a);
            } else if (b == 1) {
                res = (int) Math.pow(3, a - 1) * 4;
            } else {
                res = (int) Math.pow(3, a) * 2;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}