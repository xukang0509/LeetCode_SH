package leetcode.editor.cn;

/**
 * @Description: 反转字符串 II
 * @author: xu
 * @date: 2026-10-06 12:24:48
 */
@SuppressWarnings("all")
class ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            char[] array = s.toCharArray();
            for (int i = 0; i < array.length; i += (2 * k)) {
                int l = i, r = Math.min(i + k - 1, array.length - 1);
                while (l < r) {
                    array[l] ^= array[r];
                    array[r] ^= array[l];
                    array[l++] ^= array[r--];
                }
            }
            return new String(array);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}