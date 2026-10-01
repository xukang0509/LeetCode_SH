package leetcode.editor.cn;

/**
 * @Description: 螺旋遍历二维数组
 * @author: xu
 * @date: 2026-10-01 16:10:29
 */
@SuppressWarnings("all")
class ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralArray(int[][] array) {
            if (array == null || array.length == 0) return new int[0];

            int l = 0, r = array[0].length - 1, t = 0, b = array.length - 1;
            int x = 0;
            int[] res = new int[(r + 1) * (b + 1)];
            while (true){
                for (int i = l; i <= r; i++) res[x++] = array[t][i]; // left to right
                if (++t > b) break;
                for (int j = t; j <= b; j++) res[x++] = array[j][r]; // top to bottom
                if (--r < l) break;
                for (int k = r; k >= l; k--) res[x++] = array[b][k]; // right to left
                if (--b < t) break;
                for (int h = b; h >= t; h--) res[x++] = array[h][l]; // bottom to top
                if (++l > r) break;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}