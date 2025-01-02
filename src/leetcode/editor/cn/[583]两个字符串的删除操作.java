package leetcode.editor.cn;

/**
 * 两个字符串的删除操作
 * 2024-08-08 22:11:03
 */
@SuppressWarnings("all")
class DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        Solution solution = new DeleteOperationForTwoStrings().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 找出最长公共子序列max，之后 return word1.length + word2.length - 2 * max;
        public int minDistance(String word1, String word2) {
            if (word1 == null || word1.isEmpty()) return 0;
            if (word2 == null || word2.isEmpty()) return 0;
            char[] chars1 = word1.toCharArray();
            char[] chars2 = word2.toCharArray();
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
            int max = dp[chars2.length];
            return chars1.length + chars2.length - max * 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}