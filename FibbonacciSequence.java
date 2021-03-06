import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 11.09.2016.
 *
 *
 Even beginner programmers are usually acquainted with the Fibonacci Sequence which is generated as following:

 0-th value is 0;
 1-st value is 1;
 all next values are sum of two immediately preceeding.
 So we have:

 0: 0
 1: 1
 2: 1 = 0 + 1
 3: 2 = 1 + 1
 4: 3 = 1 + 2
 5: 5 = 2 + 3
 6: 8 = 3 + 5
 and so on, so if you continue calculations yourself, you get the the beginning of the sequence like this:

 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, ...
 One easily notes that values grow fast! The 17-th value already exceeds thousand, the 31-st is larger than million.

 Problem statement

 You will be given several Fibonacci numbers. Your task is to tell their indices in the sequence.

 Input data contain the amount of Fibonacci numbers to process.
 Next lines contain one Fibonacci number each (from the first 1000 values).
 Answer should contain their indices in the sequence, separated by spaces.

 Example:

 input data:
 5
 610
 34
 0
 1346269
 10946

 answer:
 15 9 0 31 21
 Take care: values could be of hundred or more digits long!
 */
public class FibbonacciSequence {
    public static void main (String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            BigInteger value = new BigInteger(sc.next());
            sb.append(findFibonacciIndex(value));
            if (i < count-1) {
                sb.append(" ");
                sc.nextLine();
            }
        }
        sc.close();
        printResult(sb);
    }

    private static int findFibonacciIndex(BigInteger value) {
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger tmp;
        int count = 0;
        while (value.compareTo(a) != 0) {
            tmp = a.add(b);
            a = b;
            b = tmp;
            count++;
        }
        return count;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
