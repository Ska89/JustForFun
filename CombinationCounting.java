import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 08.09.2016.
 *
 * When I was in army, sometimes (about once a week) our unit was faced a charming alternative:

 most of the hands are to be sent to fields for weeding cabbage and potato;
 few people were to be left in charge of the quarters, cleaning, washing, drying etc.
 Surely there always were many variants to choose the people for each of two occupations.

 So here we have an example of Combinations - different ways of choosing several elements from the given set
 (not regarding the order). For example, if the boy have 4 candies (of different kinds) and should take only 2 of them,
 leaving others to his younger sister, he have the following variants:

 A B C D - four sorts of candies

 A+B, A+C, A+D, B+C, B+D, C+D - six way to choose a pair of them.
 How many combinations of K elements from the set of N exist (assuming all N elements are different). It could be easily
 found that the math formula is:

 N!
 ------------- = C(N, K) - the number of different combinations
 K! * (N - K)!
 Where X! is the factorial of X, i.e. product 1 * 2 * 3 * ... * X.

 Problem statement
 You are to calculate exactly this value C(N, K) for given N and K. Note that though some languages (Python and Java
 for example) have built-in long arithmetics, it would be good if you'll find a way to minimize intermediate results
 in calculations. It would be crucial for C/C++ sometimes.

 If it is too simple for you, please try to write program for Enumerating Combinations task!

 Input data will contain the amount of test-cases.
 Next lines will contain one test-case each in form of two values (N K).
 Answer should contain C(N, K) for each case.

 Example:

 input data:
 3
 3 0
 4 2
 5 2

 answer:
 1 6 10
 Note: results would be small enough for storing in 64-bit integers.
 */
public class CombinationCounting {
    public static void main (String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(calculateCombinations(sc.nextInt(), sc.nextInt()));
            if (i < count-1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static BigInteger calculateCombinations(int a, int b) {
        return calculateFactorial(a).divide(calculateFactorial(b).multiply(calculateFactorial(a - b)));
    }

    private static BigInteger calculateFactorial(int n) {
        if (n <= 1) return BigInteger.valueOf(1);
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++)
            res = res.multiply(BigInteger.valueOf(i));
        return res;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
