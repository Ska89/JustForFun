import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 07.08.2016.
 *
 Now our goal is to learn the loops - i.e. repeated actions. Let us find the sum of several numbers (more than two). It will be useful to do this in a loop. As shown in the picture above - you can create variable sum and add every value from the list to it. Perhaps "for" loop will suit nicely since the amount of numbers is known beforehand.

 If you have troubles, try Sums In Loop first - it is, probably, easier.

 Input data has the following format:

 first line contains N - amount of values to sum;
 second line contains N values themselves.
 Answer should contain a single value - the sum of N values.

 Example:

 input data:
 8
 10 20 30 40 5 6 7 8

 answer:
 126
 Note since there are several dozens of numbers, you should not copy them manually to your program. Instead make your program reading them from standard input (where you can copy them all at once). Note that if you run code at our server, the data are automatically copied to standard input for convenience.



 */
public class SumInLoop {
    public static void main (String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(sc.nextInt() + sc.nextInt());
            if (i < count-1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
