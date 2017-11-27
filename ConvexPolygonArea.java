import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 08.10.2016.
 *
 * You have probably already wrote the program for calculating Area of Triangle - let us now get acquainted with the
 * extention of this problem - the calculation of area for arbitrary convex polygon.

 Polygon is called convex if each of its angles is less than PI/2, or in other words, if any line connecting any pair
 of points belonging to it lies completely inside. This somewhat simplifies handling of such shapes.

 You need to reduce this problem to one with triangles. We hope that pictures above may give you idea on three different
 approaches to do this.

 Input data contain the number of vertices of the polygon.
 Next lines contain a pair of numbers each - X and Y coordinates for the vertex (in correct CCW order).
 Answer should contain the area of the shape surrounded by these points.

 Example:

 input data:
 5
 51 9
 77 10
 92 71
 62 84
 29 94

 answer:
 3274.5
 */
public class ConvexPolygonArea {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] xArray = new int[count];
        int[] yArray = new int[count];
        for (int i = 0; i < count; i++) {
            xArray[i] = sc.nextInt();
            yArray[i] = sc.nextInt();
        }
        sc.close();
        printResult(calculatePolygonArea(xArray, yArray));
    }

    private static double calculatePolygonArea(int[] xArray, int[] yArray) {
        int pCount = xArray.length;
        if (pCount < 3) return 0;
        double[] lines = new double[pCount];
        for (int i = 1; i < pCount; i++) {
            lines[i - 1] = calculateDistanceBTWTwoPoints(xArray[i - 1], yArray[i - 1], xArray[i], yArray[i]);
        }
        lines[pCount - 1] = calculateDistanceBTWTwoPoints(xArray[pCount - 1], yArray[pCount - 1], xArray[0], yArray[0]);
        if (pCount == 3) return calculateTriangleArea(lines[0], lines[1], lines[2]);
        double[] inLines = new double[pCount - 3];
        int count1 = 0, count2 = 1;
        for (int i = 0; i < inLines.length; i++) {
            if (i % 2 == 0) {
                inLines[i] = calculateDistanceBTWTwoPoints(xArray[count1], yArray[count1], xArray[pCount - count2 - 1], yArray[pCount - count2 - 1]);
                count1++;
            } else {
                inLines[i] = calculateDistanceBTWTwoPoints(xArray[pCount - count2 - 1], yArray[pCount - count2 - 1], xArray[count1], yArray[count1]);
                count2++;
            }
        }
        double result = 0;
        int count3 = 0, count4 = lines.length - 3, count5 = 0;
        for (int i = 0; i < pCount - 2; i++) {
            if (i == 0) {
                result += calculateTriangleArea(lines[lines.length - 1], lines[lines.length - 2], inLines[0]);
            } else if (i == pCount - 3) {
                result += calculateTriangleArea(lines[count3 + 1], lines[count3], inLines[inLines.length - 1]);
            } else {
                if (i % 2 == 0) {
                    result += calculateTriangleArea(lines[count4], inLines[count5], inLines[count5 + 1]);
                    count4--;
                } else {
                    result += calculateTriangleArea(lines[count3], inLines[count5], inLines[count5 + 1]);
                    count3++;
                }
                count5++;
            }
        }
        return result;
    }

    private static double calculateDistanceBTWTwoPoints(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private static double calculateTriangleArea(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    private static void printResult(double res) {
        String s = String.format("%.2f", res);
        if (s.substring(s.length() - 2).equals("00")) System.out.println(s.substring(0, s.length() - 3));
        else if (s.substring(s.length() - 1).equals("0")) System.out.println(s.substring(0, s.length() - 1));
        else System.out.println(String.format("%.2f", res));
    }
}
