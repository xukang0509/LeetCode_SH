package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 反转字符串
 * 2024-08-19 22:28:28
 */
@SuppressWarnings("all")
class ReverseString {
    public static void main(String[] args) {
        Solution solution = new ReverseString().new Solution();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("s = " + Arrays.toString(s));
        solution.reverseString(s);
        System.out.println("s = " + Arrays.toString(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            int l = 0, r = s.length - 1;
            while (l < r) {
                s[l] ^= s[r];
                s[r] ^= s[l];
                s[l] ^= s[r];
                l++;
                r--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}