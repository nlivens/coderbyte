package medium;

import java.util.Scanner;

/**
 * Using the Java language, have the function OverlappingRectangles(strArr) read the strArr parameter being passed
 * which will represent two rectangles on a Cartesian coordinate plane and will contain 8 coordinates with the
 * first 4 making up rectangle 1 and the last 4 making up rectange 2. It will be in the following format:
 * ["(0,0),(2,2),(2,0),(0,2),(1,0),(1,2),(6,0),(6,2)"] Your program should determine the area of the space where the
 * two rectangles overlap, and then output the number of times this overlapping region can fit into the first rectangle.
 * For the above example, the overlapping region makes up a rectangle of area 2, and the first rectangle
 * (the first 4 coordinates) makes up a rectangle of area 4, so your program should output 2.
 * The coordinates will all be integers. If there's no overlap between the two rectangles return 0.
 *
 * @author Nick Livens
 */
public class OverlappingRectangles {
    int OverlappingRectangles(String[] strArr) {
        String[] coordinates = strArr[0].split("[)],[(]");
        coordinates[0] = coordinates[0].substring(1);
        coordinates[7] = coordinates[7].substring(0, coordinates[7].length() - 1);

        String[] rect1Coords = new String[] {coordinates[0], coordinates[1], coordinates[2], coordinates[3]};
        String[] rect2Coords = new String[] {coordinates[4], coordinates[5], coordinates[6], coordinates[7]};

        int rect1MinX = getPoint(rect1Coords, true, true);
        int rect1MaxX = getPoint(rect1Coords, false, true);
        int rect1MinY = getPoint(rect1Coords, true, false);
        int rect1MaxY = getPoint(rect1Coords, false, false);

        int rect2MinX = getPoint(rect2Coords, true, true);
        int rect2MaxX = getPoint(rect2Coords, false, true);
        int rect2MinY = getPoint(rect2Coords, true, false);
        int rect2MaxY = getPoint(rect2Coords, false, false);

        int[] rect1 = new int[] {rect1MinX, rect1MaxX, rect1MinY, rect1MaxY};
        int[] rect2 = new int[] {rect2MinX, rect2MaxX, rect2MinY, rect2MaxY};
        int[] overlapRect = getOverlappingRectangle(rect1, rect2);

        if (overlapRect == null) {
            return 0;
        }

        int rect1Size = (rect1MaxX - rect1MinX) * (rect1MaxY - rect1MinY);
        int overlapRectSize = (overlapRect[1] - overlapRect[0]) * (overlapRect[3] - overlapRect[2]);

        return overlapRectSize > 0 ? rect1Size / overlapRectSize : 0;

    }

    int getPoint(String[] rect, boolean min, boolean x) {
        int point = min ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        for (String coord : rect) {
            int coordPoint;
            if (x) {
                coordPoint = Integer.parseInt(coord.split(",")[0]);
            } else {
                coordPoint = Integer.parseInt(coord.split(",")[1]);
            }

            if (min && coordPoint < point) {
                point = coordPoint;
            } else if (!min && coordPoint > point) {
                point = coordPoint;
            }
        }

        return point;
    }

    int[] getOverlappingRectangle(int[] rect1, int[] rect2) {
        int minX, maxX, minY, maxY;

        if (rect1[0] >= rect2[0] && rect1[0] <= rect2[1]) {
            minX = rect1[0];
        } else if (rect2[0] >= rect1[0] && rect2[0] <= rect1[1]) {
            minX = rect2[0];
        } else {
            return null;
        }

        if (rect1[1] >= rect2[0] && rect1[1] <= rect2[1]) {
            maxX = rect1[1];
        } else if (rect2[1] >= rect1[0] && rect2[1] <= rect1[1]) {
            maxX = rect2[1];
        } else {
            return null;
        }

        if (rect1[2] >= rect2[2] && rect1[2] <= rect2[3]) {
            minY = rect1[2];
        } else if (rect2[2] >= rect1[2] && rect2[2] <= rect1[3]) {
            minY = rect2[2];
        } else {
            return null;
        }

        if (rect1[3] >= rect2[2] && rect1[3] <= rect2[3]) {
            maxY = rect1[3];
        } else if (rect2[3] >= rect1[2] && rect2[3] <= rect1[3]) {
            maxY = rect2[3];
        } else {
            return null;
        }

        return new int[] {minX, maxX, minY, maxY};
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        OverlappingRectangles c = new OverlappingRectangles();
        System.out.print(c.OverlappingRectangles(new String[] {"(0,0),(5,0),(0,2),(5,2),(2,1),(5,1),(2,-1),(5,-1)"}));
    }
}
