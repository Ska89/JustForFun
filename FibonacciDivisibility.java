import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 08.09.2016.
 *
 * You may refer to Fibonacci Sequence task if you are unfamiliar with the subject.

 Given usual Fibonacci Sequence, starting with 0 and 1:

 0 1 1 2 3 5 8 13 21 34 ...
 and some value M you will be asked to find the index of the first non-zero member of this list, which is evenly
 divisible by this M, e.g. if you are given M = 17 the answer is 9 (the index of the element 34).

 Input data in the first line will contain the number of test-cases.
 Next line will contain exactly this of divisors M (not exceeding 10000) for which you should give answers.
 Answer should contain indices of members of Fibonacci Sequence, separated by spaces.

 Example:

 input data:
 3
 17 12 61

 answer:
 9 12 15


 */
public class FibonacciDivisibility {
    public static void main (String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(findFibonacciIndex(new BigInteger(sc.next())));
            if (i < count-1) {
                sb.append(" ");
            }
        }
        sc.close();
        printResult(sb);
    }

    private static int findFibonacciIndex(BigInteger m) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger tmp;
        int count = 0;
        do {
            tmp = a.add(b);
            a = b;
            b = tmp;
            count++;
        }
        while (a.remainder(m).compareTo(BigInteger.ZERO) != 0);
        return count;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
