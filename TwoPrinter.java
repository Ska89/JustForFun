import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 15.08.2016.
 *
 * My colleague have retold me this puzzle after visiting an interview at local office of Oracle company. I hope
 * I remember it correctly.

 John and Mary founded J&M publishing house and bought two old printers to equip it.

 Now they have their first commercial deal - to print a document consisting of N pages.

 It appears that printers work at different speed. One produces a page in X seconds and other does it in Y seconds.

 So now company founders are curious about minimum time they can spend on printing the whole document with two printers.

 Input data contains number of test cases in the first line.
 Then test-cases will follow, each in separate line.
 Each testcase contains three integer values - X Y N, where N will not exceed 1,000,000,000.
 Answer should contain minumum printing times for each of testcases, separated by spaces.

 Example:

 input data:
 2
 1 1 5
 3 5 4

 answer:
 3 9
 */
public class TwoPrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(calculatePrintingTimes(sc.nextInt(), sc.nextInt(), sc.nextInt()));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static int calculatePrintingTimes(int x, int y, int n) {
        if (x == y) return (int) Math.round((double) n / 2) * x;
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        int resX = min;
        int resY = max;
        int k = 1;

        while (n > k) {
            resX += min;
            k++;
            if (n == k) break;
            if (resX > resY) {
                resY += max;
                k++;
            }
        }
        return resX > resY ? resY : resX;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
