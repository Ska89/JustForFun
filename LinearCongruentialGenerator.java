import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 11.09.2016.
 *
 *
 If you solved the task about Neumann's Random Generator you are already aware that not all methods of generating
 pseudo-random sequences are good. Particularly, Neumann's method is not suitable for anything except programming
 exercises.

 Here is the other method which is more widespread (it is implemented in most of programming languages and libraries)
 and still simple enough: let us start with some initial number and generate each new member Xnext of a sequence by
 the current Xcur using the following rule:

 Xnext = (A * Xcur + C) % M
 So we need three constants to define such a sequence (and an initial number). Not all combinations of constants are
 good (you may read details at Random Numbers), however, here are many good variants which allow to produce sequences
 with period of M, i.e. significantly long.

 In this task we are going to build this algorithm to tell the value of n-th member of a sequence.

 Input data will contain the number of test-cases in the first line.
 Then test-cases will follow, each in separate line.
 Test-case consists of five values: A, C, M, X0, N where first three are the same as in formula, while X0 is the
 initial member of a sequence and N is the number of a member which we want to calculate.
 Answer should contain N-th member's value for each test-case, separated by spaces.

 Example:

 input data:
 2
 3 7 12 1 2
 2 3 15 8 10

 answer:
 1 11


 */
public class LinearCongruentialGenerator {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(generateValue(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static int generateValue(int a, int c, int m, int x, int n) {
        int count = 0;
        while (count != n) {
            x = (a * x + c) % m;
            count++;
        }
        return x;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
