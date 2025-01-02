package leetcode.editor.cn;

/**
 * x 的平方根
 * 2024-08-13 11:32:58
 */
@SuppressWarnings("all")
class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            int l = 1, r = x;
            while (l <= r) {
                int mid = (l + r) >>> 1;
                if ((x / mid) >=  mid) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}