package leetcode.editor.cn;

/**
 * 最长公共子序列
 * 2024-08-08 21:39:20
 */
@SuppressWarnings("all")
class LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            if (text1 == null || text1.isEmpty()) return 0;
            if (text2 == null || text2.isEmpty()) return 0;
            char[] chars1 = text1.toCharArray();
            char[] chars2 = text2.toCharArray();
            if (chars1.length < chars2.length) {
                char[] temp = chars1;
                chars1 = chars2;
                chars2 = temp;
            }
            int[] dp = new int[chars2.length + 1];
            for (int i = 1; i < chars1.length + 1; i++) {
                int cur = 0;
                for (int j = 1; j < chars2.length + 1; j++) {
                    int leftTop = cur;
                    cur = dp[j];
                    if (chars1[i - 1] == chars2[j - 1]) {
                        dp[j] = leftTop + 1;
                    } else {
                        dp[j] = Integer.max(dp[j], dp[j - 1]);
                    }
                }
            }
            return dp[chars2.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}