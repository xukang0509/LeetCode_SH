package leetcode.editor.util;

/**
 * @author xk
 * @since 2024-09-11 18:53
 */
public class Main {
    public boolean isIntersect(Time[] times) {
        if (times.length <= 1) return true;
        for (int i = 1; i < times.length; i++) {
            if (getTimeStamps(times[i - 1].getEndTime()) > getTimeStamps(times[i].getStartTime())) {
                return false;
            }
        }
        return true;
    }

    private int getTimeStamps(String time) {
        String[] splits = time.split(":");
        int hour = Integer.valueOf(splits[0]);
        int minute = Integer.valueOf(splits[1]);
        return hour * 60 + minute;
    }
}
