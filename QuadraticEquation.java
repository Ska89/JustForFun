import java.util.Scanner;

/**
 *
 * Created by @Serhii Sydorenko on 12.09.2016.
 *
 *
 * Now we are to create a program for solving quadratic equation. Supposedly you have learnt in school that such
 * equation has a form of:

 A * x^2 + B * x + C = 0
 where A, B and C are some constants (called "coefficients" of equation) and x is a variable. To solve such equation
 means to find x for which the formula becomes true. For example with coefficients 3, -5 and -2 we have equation:

 3 * x^2 - 5 * x - 2 = 0
 and we can see that value x = 2 is quite suitable.

 General formula for finding such values (or "roots") via coefficients of equation is the following:

 x1 = (-B + sqrt(B^2 - 4*A*C)) / (2*A)
 x2 = (-B - sqrt(B^2 - 4*A*C)) / (2*A)
 For example above these expressions will produce:

 x1 = (5 + sqrt(5^2 + 4*3*2)) / (2*3) = (5 + 7) / 6 = 2
 x2 = (5 - sqrt(5^2 + 4*3*2)) / (2*3) = (5 - 7) / 6 = -1/3
 I.e. the equation really has two roots. Strictly speaking, here are always two roots. However, they could be: -
 either distinct, when expression under sqrt is positive; - or equal, when expression under sqrt is zero; - and in
 other cases even complex numbers - i.e. values like U+V*i where i = sqrt(-1).

 Refer to wikipedia for more about Complex Numbers or Quadratic Equations at whole.

 Input data will contain number of test-cases in the first line.
 Each of test-cases will consist of three values (for A, B and C respectively).
 Answer should contain a pair of roots for each case (even when they are equal). Use space to separate values of the
 pair and use semicolon followed by space to separate pairs themselves. Complex numbers should be given
 like 5-2i or -1+1i.

 Note also:

 order of values inside the pair is important - for real roots output the bigger one first; for complex roots
 output a+bi first and a-bi last;
 roots would be always expressed with integer numbers in this task, so print no any decimal points etc.
 Example:

 input data:
 3
 3 -3 -6
 1 0 1
 9 90 225

 answer:
 2 -1; 0+1i 0-1i; -5 -5
 */
public class QuadraticEquation {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(solveEquation(sc.nextInt(), sc.nextInt(), sc.nextInt()));
            if (i < count - 1) sb.append("; ");
        }
        sc.close();
        printResult(sb);
    }

    private static String solveEquation(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int q = b * b - 4 * a * c;
        int sqrt = (int) Math.sqrt(Math.abs(q));
        sb.append(q < 0 ?
                String.format("%1$d+%2$di %1$d-%2$di", -b / (2 * a), sqrt / (2 * a)) :
                String.format("%d %d", (-b + sqrt) / (2 * a), (-b - sqrt) / (2 * a)));

        return sb.toString();
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
