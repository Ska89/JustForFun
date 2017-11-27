import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 18.08.2016.
 *
 * This task is inspired by the discussion in the Blog on algorithms by Faisal Rahman on similar task from ProjectEuler

 As we know, the Pythagorean Theorem tells us about the simple equation:

 a^2 + b^2 = c^2
 There really exist such triples a, b, c of integer numbers, which satisfy this equation. This is not self-evident
 fact, moreover there are no such triples for any other powers except 2 - this is the famous Fermat Theorem which
 could not be solved for more than 350 years.

 However, for the power of 2 there are countless amount of such triples. One of them 3, 4, 5, for example.

 Nevertheless, it is not always easy to find a triple satisfying some specific conditions:

 In this problem you need to write a program which for given value of s = a + b + c will find the only triple which
 satisfies the equation.

 For example, given sum of 12 the only 3, 4, 5 triple fits, for sum 30 the only 5, 12, 13 etc.

 Input data will contain the number of test-cases in the first line.
 Other lines will contain a single value each - the sum for which triple should be found.
 Answer should contain the values of c^2 for each triple found (it is equal to a^2 + b^2 of course), separated with
 spaces.

 Note: the real values of s would be large enough, about 10e+7 - so the simplest solutions could be inefficient.

 Example:

 input data:
 2
 12
 30

 answer:
 25 169

 */
public class PythagoreanTheorem {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(checkTriangleType(sc.nextInt(), sc.nextInt(), sc.nextInt()));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static char checkTriangleType(int a, int b, int c) {
        int d = (int) Math.sqrt(a * a + b * b);
        if (c == d) return 'R';
        if (c < d) return 'A';
        return 'O';
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
