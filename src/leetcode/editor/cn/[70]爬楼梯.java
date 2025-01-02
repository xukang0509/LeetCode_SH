package leetcode.editor.cn;

/**
 * 爬楼梯
 * 2024-06-01 09:08:32
 */
class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            if (n == 1 || n == 2) return n;
            int p1 = 1, p2 = 2;
            for (int i = 3; i <= n; i++) {
                p2 = p1 + p2;
                p1 = p2 - p1;
            }
            return p2;
        }


        public int climbStairs1(int n) {
            if (n == 1 || n == 2) return n;
            int[] cache = new int[n + 1];
            cache[1] = 1;
            cache[2] = 2;
            return climbStairs(n, cache);
        }

        public int climbStairs(int n, int[] cache) {
            if (cache[n] != 0) return cache[n];
            cache[n] = climbStairs(n - 1, cache) + climbStairs(n - 2, cache);
            return cache[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}