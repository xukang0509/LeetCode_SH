package leetcode.editor.cn;

/**
 * @Description: 比较含退格的字符串
 * @author: xu
 * @date: 2026-09-27 21:08:24
 */
@SuppressWarnings("all")
class BackspaceStringCompare {
    public static void main(String[] args) {
        Solution solution = new BackspaceStringCompare().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean backspaceCompare(String s, String t) {
            int sIndex = s.length() - 1, tIndex = t.length() - 1;
            int skipS = 0, skipT = 0;
            while (sIndex >= 0 || tIndex >= 0) {
                while (sIndex >= 0) {
                    if (s.charAt(sIndex) == '#') {
                        skipS++;
                        sIndex--;
                    } else if (skipS > 0) {
                        skipS--;
                        sIndex--;
                    } else {
                        break;
                    }
                }
                while (tIndex >= 0) {
                    if (t.charAt(tIndex) == '#') {
                        skipT++;
                        tIndex--;
                    } else if (skipT > 0) {
                        skipT--;
                        tIndex--;
                    } else {
                        break;
                    }
                }
                if (sIndex >= 0 && tIndex >= 0) {
                    if (s.charAt(sIndex) != t.charAt(tIndex)) return false;
                } else if (sIndex >= 0 || tIndex >= 0) return false;
                sIndex--;
                tIndex--;
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}