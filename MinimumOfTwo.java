import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 07.08.2016.
 *
 *Most programs should be able to make some choices and decisions. And we are going to practice conditional programming now.
 This is usually done by a kind of if ... else statements which may look like:

 IF some_condition THEN
 do_something
 ELSE
 do_other_thing
 ENDIF
 Depending on your programming language syntax could be different and else part is almost always optional. You can read more in wikipedia article on Conditional statements.

 Of two numbers, please, select one with minimum value. Here are several pairs of numbers for thorough testing.

 Input data will contain number of test-cases in the first line.
 Following lines will contain a pair of numbers to compare each.
 For Answer please enter the same amount of minimums separated by space, for example:

 data:
 3
 5 3
 2 8
 100 15

 answer:
 3 2 15


 *
 */
public class MinimumOfTwo {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(compareTwoIntsForMin(sc.nextInt(), sc.nextInt()));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static int compareTwoIntsForMin(int a, int b) {
        return (a < b) ? a : b;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
