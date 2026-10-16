package leetcode.editor.extend;

/**
 * @description:
 * @author: xu
 * @date: 2026/10/6 12:51
 */
@SuppressWarnings("ALL")
public class ReplaceNum {
    public static void main(String[] args) {
        System.out.println("anumberbnumbercnumber".equals(replaceNumber("a1b2c3")) + ":" + replaceNumber("a1b2c3")); // 输出：anumberbnumbercnumber
        System.out.println("anumberb".equals(replaceNumber("a5b")) + ":" + replaceNumber("a5b")); // 输出：anumberb
        System.out.println("abc".equals(replaceNumber("abc")) + ":" + replaceNumber("abc")); // 输出：abc
    }

    /**
     * 给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。
     * 例：
     * a1b2c3 -> anumberbnumbercnumber
     * a5b -> anumberb
     * @date: 2026/10/6 13:08
     */
    private static String replaceNumber(String s) {
        final char[] oldChars = s.toCharArray();
        final int oldLen = s.length();
        int numCount = 0;
        for (char c : oldChars) {
            if (c >= '0' && c <= '9') numCount++;
        }
        if (numCount == 0) return s;

        final int newLen = oldLen + numCount * 5;
        final char[] newChars = new char[newLen];

        for (int newIdx = 0, oldIdx = 0; oldIdx < oldLen && newIdx < newLen; newIdx++, oldIdx++) {
            char ch = oldChars[oldIdx];
            if (ch >= '0' && ch <= '9') {
                newChars[newIdx++] = 'n';
                newChars[newIdx++] = 'u';
                newChars[newIdx++] = 'm';
                newChars[newIdx++] = 'b';
                newChars[newIdx++] = 'e';
                newChars[newIdx] = 'r';
            } else {
                newChars[newIdx] = ch;
            }
        }
        return new String(newChars);
    }
}
