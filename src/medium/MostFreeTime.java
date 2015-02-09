package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Have the function MostFreeTime(strArr) read the strArr parameter being passed which will represent a full day and
 * will be filled with events that span from time X to time Y in the day. The format of each event will be
 * hh:mmAM/PM-hh:mmAM/PM. For example, strArr may be ["10:00AM-12:30PM","02:00PM-02:45PM","09:10AM-09:50AM"].
 * Your program will have to output the longest amount of free time available between the start of your first event
 * and the end of your last event in the format: hh:mm. The start event should be the earliest event in the day and
 * the latest event should be the latest event in the day. The output for the previous input would therefore be 01:30
 * (with the earliest event in the day starting at 09:10AM and the latest event ending at 02:45PM).
 * The input will contain at least 3 events and the events may be out of order.
 *
 * @author Nick Livens
 */
public class MostFreeTime {
    final int MINUTES_IN_HOUR = 60;
    final int MINUTES_IN_DAY = 24 * 60;

    String MostFreeTime(String[] strArr) {
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String s, String s2) {
                int endTime = getMinuteOfDay(s.split("-")[1]);
                int startTime = getMinuteOfDay(s2.split("-")[0]);

                if (endTime == startTime) return 0;
                if (endTime > startTime) return 1;
                return -1;
            }
        });

        int biggestDiff = Integer.MIN_VALUE;
        for (int i = 1; i < strArr.length; i++) {
            int endEvent = getMinuteOfDay(strArr[i - 1].split("-")[1]);
            int startEvent = getMinuteOfDay(strArr[i].split("-")[0]);
            int diff = getDiff(endEvent, startEvent);

            if (diff > biggestDiff) {
                biggestDiff = diff;
            }
        }

        return translate(biggestDiff);

    }

    int getMinuteOfDay(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1].substring(0, parts[1].length() - 2));

        if (hour == 12) hour = 0;

        int minOfDay = time.toLowerCase().contains("pm") ? (hour * MINUTES_IN_HOUR) + min + (MINUTES_IN_DAY / 2) : (hour * MINUTES_IN_HOUR) + min;
        return minOfDay > MINUTES_IN_DAY ? minOfDay - MINUTES_IN_DAY : minOfDay;
    }

    int getDiff(int startTime, int endTime) {
        if (startTime <= endTime) return endTime - startTime;
        return (MINUTES_IN_DAY - startTime) + endTime;
    }

    String translate(int time) {
        int hours = (int) Math.floor(time / (double) MINUTES_IN_HOUR);
        int minutes = time - (hours * MINUTES_IN_HOUR);

        return String.format("%02d:%02d", hours, minutes);
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        MostFreeTime c = new MostFreeTime();
        System.out.print(c.MostFreeTime(new String[] {"12:15PM-02:00PM","09:00AM-10:00AM","10:30AM-12:00PM"}));
    }
}
