package leetcode.editor.cn;

/**
 * @Description: 赎金信
 * @author: xu
 * @date: 2026-10-03 12:46:55
 */
@SuppressWarnings("all")
class RansomNote {
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] hash = new int[26];
            for (char c : ransomNote.toCharArray()) {
                hash[c - 'a']++;
            }
            for (char c : magazine.toCharArray()) {
                hash[c - 'a']--;
            }
            for (int i : hash) {
                if (i > 0) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}