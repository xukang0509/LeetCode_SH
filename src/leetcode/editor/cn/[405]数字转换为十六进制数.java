package leetcode.editor.cn;

/**
 * @Description: 数字转换为十六进制数
 * @author: xu
 * @date: 2026-10-05 15:44:19
 */
@SuppressWarnings("all")
class ConvertANumberToHexadecimal {
    public static void main(String[] args) {
        Solution solution = new ConvertANumberToHexadecimal().new Solution();
        // TO TEST
        System.out.println("solution.toHex(111111) = " + solution.toHex(111111));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final String[] HEX_HASH = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

        public String toHex(int num) {
            if (num == 0) return "0";
            StringBuilder sb = new StringBuilder();
            for (int shift = 28; shift >= 0; shift -= 4) {
                int a = (num >>> shift) & 0xf;
                if (!sb.isEmpty() || a != 0) sb.append(HEX_HASH[a]);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}