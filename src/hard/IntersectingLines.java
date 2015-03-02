package hard;

import java.util.Scanner;

/**
 * Using the Java language, have the function IntersectingLines(strArr) take strArr which will be an array of
 * 4 coordinates in the form: (x,y). Your program should take these points where the first 2 form a line and the
 * last 2 form a line, and determine whether the lines intersect, and if they do, at what point.
 * For example: if strArr is ["(3,0)","(1,4)","(0,-3)","(2,3)"], then the line created by (3,0) and (1,4) and the line
 * created by (0,-3) (2,3) intersect at (9/5,12/5). Your output should therefore be the 2 points in fraction form in
 * the following format: (9/5,12/5). If there is no denominator for the resulting points, then the output should just
 * be the integers like so: (12,3). If any of the resulting points is negative, add the negative sign to the numerator
 * like so: (-491/63,-491/67). If there is no intersection, your output should return the string "no intersection".
 * The input points and the resulting points can be positive or negative integers.
 *
 * @author Nick Livens
 */
public class IntersectingLines {
    String IntersectingLines(String[] strArr) {
        int[][] coords = new int[4][2];
        for (int i = 0; i < 4; i++) {
            String[] strCoords = strArr[i].split(",");
            coords[i][0] = Integer.parseInt(strCoords[0].substring(1));
            coords[i][1] = Integer.parseInt(strCoords[1].substring(0, strCoords[1].length() - 1));
        }

        int x1 = coords[0][0], x2 = coords[1][0], x3 = coords[2][0], x4 = coords[3][0];
        int y1 = coords[0][1], y2 = coords[1][1], y3 = coords[2][1], y4 = coords[3][1];

        int xTop = (x1*y2 - y1*x2) * (x3 - x4) - (x1 - x2) * (x3*y4 - y3*x4);
        int xBot = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        int yTop = (x1*y2 - y1*x2) * (y3 - y4) - (y1 - y2) * (x3*y4 - y3*x4);
        int yBot = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

        if (xBot == 0 || yBot == 0) {
            return "no intersection";
        }

        if (xTop < 0 && xBot < 0) {
            xTop = Math.abs(xTop);
            xBot = Math.abs(xBot);
        } else if (xBot < 0) {
            xTop = xTop * -1;
            xBot = Math.abs(xBot);
        }

        if (yTop < 0 && yBot < 0) {
            yTop = Math.abs(yTop);
            yBot = Math.abs(yBot);
        } else if (yBot < 0) {
            yTop = yTop * -1;
            yBot = Math.abs(yBot);
        }

        int xGcm = xTop > xBot ? Math.abs(gcm(xTop, xBot)) : Math.abs(gcm(xBot, xTop));
        int yGcm = yTop > yBot ? Math.abs(gcm(yTop, yBot)) : Math.abs(gcm(yBot, yTop));
        String x = xTop % xBot == 0 ? String.valueOf(xTop / xBot) : (xTop / xGcm) + "/" + (xBot / xGcm);
        String y = yTop % yBot == 0 ? String.valueOf(yTop / yBot) : (yTop / yGcm) + "/" + (yBot / yGcm);
        return "(" + x + "," + y + ")";
    }

    int gcm(int a, int b) {
        return b == 0 ? a : gcm(b, a % b);
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        IntersectingLines c = new IntersectingLines();
        System.out.print(c.IntersectingLines(new String[] {"(6,12)","(7,14)","(-100,-3)","(-3,-5)"}));
    }
}
