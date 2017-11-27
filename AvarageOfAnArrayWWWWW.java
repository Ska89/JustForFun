import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 11.08.2016.
 *
 * Important branch of mathematics which heavily uses programming is statistics - i.e. calculation of characteristics
 * for some data. (Just think of statistics of visitors / pageviews of the web-site etc.) Learning this discipline is
 * usually started from acquaintance with an average value.
 * Average (or mean) value of some numbers could be calculated as their sum divided by their amount. For example:
 * avg(2, 3, 7) = (2 + 3 + 7) / 3 = 4
 * avg(20, 10) = (20 + 10) / 2 = 15
 * You will be given several arrays, for each of which you are to find an average value.
 * Input data will give the number of test-cases in the first line.
 * Then test-cases themselves will follow, one case per line.
 * Each test-case describes an array of positive integers with value of 0 marking end. (this zero should not be included
 * into calculations!!!).
 * Answer should contain average values for each array, rounded to nearest integer (see task on rounding),
 * separated by spaces.
 * Example:
 * input data:
 * 3
 * 2 3 7 0
 * 20 10 0
 * 1 0
 * answer:
 * 4 15 1
 */
public class AvarageOfAnArrayWWWWW {
    public static void main (String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(calculateAverageFromString(sc.nextLine()));
            if (i < count-1) {
                sb.append(" ");
            }
        }
        sc.close();
        printResult(sb);
    }

    private static int calculateAverageFromString(String s) {
        int sum = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 0) {
            int index = sb.indexOf(" ");
            if (index == -1) {
                sb.delete(0, sb.length());
            }
            else {
                sum += Integer.parseInt(sb.substring(0, index));
                sb.delete(0, index+1);
                count++;
            }
        }
        return (int) Math.round((double) sum/count);
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
