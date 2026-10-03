package leetcode.editor.cn;

/**
 * @Description: 快乐数
 * @author: xu
 * @date: 2026-10-03 11:06:57
 */
@SuppressWarnings("all")
class HappyNumber {
    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();
        // TO TEST
        solution.isHappy(19);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            int slow = n;
            int fast = getNextNum(n);
            while (fast != 1 && fast != slow) {
                slow = getNextNum(slow);
                fast = getNextNum(getNextNum(fast));
            }
            return fast == 1;
        }

        private int getNextNum(int n) {
            int res = 0;
            while (n > 0) {
                int i = n % 10;
                res += i * i;
                n /= 10;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}