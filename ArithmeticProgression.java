import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 18.08.2016.
 *
 * When we speak about arithmetic progression (or arithmetic sequence) we mean a series of numbers with a special
 * roperty - each value is followed by the other, greater by predefined amount (step).
 * I.e. difference of (K+1)-th and K-th values is a constant. Here are examples of sequences
 * 1 2 3 4 5 6 7 ...
 * 4 6 8 10 12 14 16...
 * 10 13 16 19 22 25 28...
 * Since so, arithmetic sequence is completely defined by the first member (A) and the increment value - step size - (B).
 * First few members could be expressed as
 * A + (A + B) + (A + 2B) + (A + 3B) + ...
 * You are to calculate the sum of first members of arithmetic sequence. Wikipedia page on arithmetic progression could
 * be of significant help to one who meets them for the first time.
 * Input data: first line contains the number of test-cases.
 * Other lines contain test-cases in form of triplets of values A B N where A is the first value of the sequence,
 * B is the step size and N is the number of first values which should be accounted.
 * Answer: you are to output results (sums of N first members) for each sequence, separated by spaces.
 * Example:
 * data:
 * 2
 * 5 2 3
 * 3 0 10
 * answer:
 * 21 30

 */
public class ArithmeticProgression {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(calculateProgressionSum(sc.nextInt(), sc.nextInt(), sc.nextInt()));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static int calculateProgressionSum(int a, int b, int n) {
        if (b == 0 && n != 0) return a * n;
        int res = a;
        for (int i = 1; i < n; i++) {
            res += a + b * i;
        }
        return res;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
