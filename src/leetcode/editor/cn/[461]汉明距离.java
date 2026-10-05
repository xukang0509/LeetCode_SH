package leetcode.editor.cn;

/**
 * @Description: 汉明距离
 * @author: xu
 * @date: 2026-10-05 16:46:22
 */
@SuppressWarnings("all")
class HammingDistance {
    public static void main(String[] args) {
        Solution solution = new HammingDistance().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hammingDistance(int x, int y) {
            int s = x ^ y;
            int ret = 0;
            while (s != 0) {
                s &= s - 1;
                ret++;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}