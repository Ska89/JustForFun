import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 17.10.2016.
 *
 * The face of analog clock has two hands and is proportionally divided by 12 marks. The shorter hour hand makes the
 * whole turn (360 degrees) in 12 hours, while the longer minute hand makes the whole circle each hour. See Clock Face
 * on wiki for more details.

 Suppose, the Cartesian Coordinate System (i.e. ordinary rectangular coordinate grid) is placed upon the clock face so
 that the center of the face has coordinates 10, 10 and Y axis is directed upwards while X axis is directed to the right
 (i.e. at 3:00 minute hand is parallel to Y axis and hour hand is parallel to X axis).

 Assuming the length of the minute hand be 9 and the length of the hour hand be 6 you are to find coordinates of the
 hand ends for each given time - e.g. (16 10) and (10 19) for the time 3:00.

 Input data contain the number of test cases.
 Following line contains the testcases themselves in form 3:15, 21:44 etc.
 Answer should contain four real numbers for each test case - X and Y coordinates for hour hand, then X and Y coordinate
 for minute hand. All values should be simply separated with spaces.

 Real values should have accuracy of 1e-7 or better. Time is specified as a value from 0:00 to 23:59.

 Example:

 input data:
 3
 12:00 15:00 9:30

 answer:
 10.0 16.0 10.0 19.0 16.0 10.0 10.0 19.0 4.20444504 11.55291427 10.0 1.0

 */
public class ClockHands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(findClockHandsCoordinates(sc.next()));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static String findClockHandsCoordinates(String s) {
        int divider = s.indexOf(':');
        int hours = Integer.parseInt(s.substring(0, divider));
        hours %= 12;
        int minutes = Integer.parseInt(s.substring(divider + 1));

        double mAngle = minutes * 6 * (Math.PI / 180);
        double hAngle = (hours + (double) minutes / 60) * 30 * (Math.PI / 180);

        double hX = 6 * (Math.sin(hAngle)) + 10;
        double hY = 6 * (Math.cos(hAngle)) + 10;
        double mX = 9 * Math.sin(mAngle) + 10;
        double mY = 9 * Math.cos(mAngle) + 10;

        return hX + " " + hY + " " + mX + " " + mY;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
