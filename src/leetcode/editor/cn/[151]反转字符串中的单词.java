package leetcode.editor.cn;

/**
 * @Description: 反转字符串中的单词
 * @author: xu
 * @date: 2026-10-06 13:18:16
 */
@SuppressWarnings("all")
class ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString().new Solution();
        // TO TEST
        System.out.println("solution.reverseWords(\"the sky is blue\") = " + solution.reverseWords("the sky is blue"));
        System.out.println("solution.reverseWords(\"  hello world  \") = " + solution.reverseWords("  hello world  "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            char[] initalArr = s.toCharArray();
            char[] newArr = new char[initalArr.length + 1];

            int newArrPos = 0;
            int i = initalArr.length - 1;
            while (i >= 0) {
                while (i >= 0 && initalArr[i] == ' ') i--;
                int right = i;
                while (i >= 0 && initalArr[i] != ' ') i--;
                for (int j = i + 1; j <= right; j++) {
                    newArr[newArrPos++] = initalArr[j];
                    if (j == right) newArr[newArrPos++] = ' ';
                }
            }
            return newArrPos == 0 ? "" : new String(newArr, 0, newArrPos - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}