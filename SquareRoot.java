import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 06.09.2016.
 *
 * Many mathematical problems are solved in programming not precisely, but approximately, by several
 * computations of the result, each of which is more and more close to the goal.

 Let us practice the method of approximate calculation of the square root with the following approach:

 Let us search for square root r of the given value X.
 Use some arbitrary value, say r = 1 as the first approximation (surely it is too rough).
 For proper square root the equation r = X / r should hold.
 So let us calculate d = X / r (it would not be equal to r since r is not precise root).
 And take average between r and d as the new approximation.
 E.g. overall formula of the calculation step is (here := is an assignment):

 r  +  X / r
 r := -------------
 2
 Refer to Square Root Approximation article for more details on the Heron's Method.

 So we are given values X for which to perform calculations and number of steps N to perform.
 Use r = 1 at the beginning, and output resulting approximation (after N steps).

 Input data will give the number of test-cases in first line.
 Next lines will contain test-cases themselves, each containing the value X for which square root should be
 calculated and N - the number of calculation steps.
 Answer should contain calculated approximations for each case, separated by space.

 Example:

 input data:
 3
 150 0
 5 1
 10 3

 answer:
 1 3 3.196
 Results should have precision of 1e-7 = 0.0000001 or better!
 */
public class SquareRoot {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(calculateApproximation(sc.nextInt(), sc.nextInt()));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static double calculateApproximation(int x, int n) {
        double r = 1;
        while (n > 0) {
            r = (r + (double) x / r) / 2;
            n--;
        }
        return r;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
