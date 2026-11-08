package leetcode.editor.cn;

/**
 * @Description: 504 七进制数 base-7
 * @author: xu
 * @date: 2026-11-01 22:09:58
 */
@SuppressWarnings("all")
class Base7 {
    public static void main(String[] args) {
        Solution solution = new Base7().new Solution();
        // TO TEST
        System.out.println("solution.convertToBase7(-7) = " + solution.convertToBase7(-7));
        System.out.println("solution.convertToBase7(100) = " + solution.convertToBase7(100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToBase7(int num) {
            if (num == 0) return "0";
            boolean isNegative = num < 0;
            num = Math.abs(num);
            StringBuilder stack = new StringBuilder();
            while (num != 0) {
                stack.append(num % 7);
                num /= 7;
            }
            if (isNegative) stack.append("-");
            return stack.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}