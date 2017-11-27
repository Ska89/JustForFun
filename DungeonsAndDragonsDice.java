import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 15.09.2016.
 *
 * In the complex dice-based games players can use several dice and with number of sides other than 6. For example,
 * the damage given by some powerful sword could be calculated as the sum of 3 dice with 8 sides each (i.e. having
 * numbers from 1 to 8) - this means the weakest possible damage is 3 and strongest is 24, however most probable values
 * would be 13 and 14.

 The notation used in the descriptions of such games looks like 3d8 - i.e. 3 dice with 8 sides, or 2d6 for more common
 variant of 2 dice with 6 sides each. Tossing of 5 coins each of which has only 2 sides would be written as 5d2.

 In this task you will be given results of casting some dice set many times. Your task would be to determine how many
 dice are in the set and how many sides dice have. Supposedly you'll need some program to calculate statistics on these
 results to classify them.

 Due to probabilistic nature of the problem you may fail at first attempt, however try a few times - and if your
 algorithm is correct, your answer will be accepted.

 For this problem dice could have 2, 4, 6, 8, 10 or 12 sides. The number of dice could be from 1 to 5.

 Input data contain 303 values in 3 lines.
 Each line contains 100 non-zero results of casting (sums of dice points), terminated with spare 0 which should not be
 counted (it only marks the end of the line).
 Answer should contain three description of dice sets for each of three lines, in form xdy where x and y are numbers
 of dice and of sides respectively.

 Example: (not shown full due to long lines)

 input data:
 8 11 23 4 12 15 13 3 ... 7 14 5 13 0
 7 6 3 5 8 7 10 11 3 7 ... 6 9 7 2 0
 7 6 5 6 7 9 8 7 8 8 10 ... 8 10 8 7 0

 answer:
 3d8 2d6 5d2

 */
public class DungeonsAndDragonsDice {
    private static final int[] COUNT = {1, 2, 3, 4, 5};
    private static final int[] SIDES = {2, 4, 6, 8, 10, 12};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < 3; k++) {
            int[] array = new int[100];
            for (int i = 0; i < 100; i++)
                array[i] = sc.nextInt();
            sc.nextInt();
            sb.append(determineDiceCountAndType(array));
            if (k < 2) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static String determineDiceCountAndType(int[] array) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i : array) {
            if (i < min) min = i;
            if (i > max) max = i;
            sum += i;
        }
        for (int sides : SIDES) {
            for (int count : COUNT) {
                if (max <= count * sides && min >= count
                        && Math.abs(sum / 100 - (sides * count + count) / 2) < 3) {
                    sb.append(String.format("%dd%d", count, sides));
                    return sb.toString();
                }
            }
        }
        return "1d1";
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res.toString().trim());
    }
}
