package leetcode.editor.cn;

/**
 * @Description: 统计共同度过的日子数
 * @author: xu
 * @date: 2026-10-24 18:48:53
 */
@SuppressWarnings("all")
class CountDaysSpentTogether {
    public static void main(String[] args) {
        Solution solution = new CountDaysSpentTogether().new Solution();
        // TO TEST
        solution.countDaysTogether("10-01", "10-31", "11-01", "12-31");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int[] PREFIX_SUM = new int[13];

        static {
            int[] dayOfMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            for (int i = 0; i < 12; i++) {
                PREFIX_SUM[i + 1] = PREFIX_SUM[i] + dayOfMonths[i];
            }
        }

        public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
            int arriveAliceDay = calculateDayOfYears(arriveAlice);
            int leaveAliceDay = calculateDayOfYears(leaveAlice);
            int arriveBobDay = calculateDayOfYears(arriveBob);
            int leaveBobDay = calculateDayOfYears(leaveBob);
            return Math.max(0, Math.min(leaveAliceDay, leaveBobDay) - Math.max(arriveAliceDay, arriveBobDay) + 1);
        }

        private int calculateDayOfYears(String date) {
            int month = Integer.parseInt(date.substring(0, 2));
            int day = Integer.parseInt(date.substring(3));
            return PREFIX_SUM[month - 1] + day;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}