import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 07.10.2016.
 *
 * Dice game of Yacht is played with 5 standard dice (having from 1 to 6 points on their sides). The player's goal is
 * to gather some beautiful combination of points. Suppose, the following combinations are respected:

 two of dice have the same points, like 3 6 5 6 1 - called pair;
 three of dice have the same points, like 2 4 5 4 4 - called three;
 four of dice have the same points, like 1 4 1 1 1 - called four;
 all five dice have the same points, like 2 2 2 2 2 - called yacht;
 two pairs at once, like 3 6 5 3 5 - called two-pairs;
 pair and three at once, like 1 6 6 1 6 - called full-house;
 sequence from 1 to 5, like 2 4 3 5 1 - called small-straight;
 sequence from 2 to 6, like 6 3 4 2 5 - called big-straight.
 (combinates named with two words are written with dash here for consistency with answers which our code will produce)

 Such combinations increases player's score by different values, but it is not important now.

 Our goal is to write a program which for given combination of dice will determine its type.

 Input data contains a number of test-cases in the first line.
 Next lines contain 5 values each - points of player's dice.
 Answer should contain the name for each of combinations. Names could be pair, two-pairs, three, four, yacht,
 full-house, small-straight, big-straight or none, separated with spaces.

 Example:

 input data:
 3
 3 6 5 6 1
 1 6 6 1 6
 2 4 3 5 1

 answer:
 pair full-house small-straight
 You can read more about the game itself at wikipedia article on Yacht - do not be surprised of slightly different
 combinations set, it is not universally agreed upon.
 */
public class YahtOrDicePocker {
    private static final String PAIR = "pair", TWO_PAIRS = "two-pairs", THREE = "three", FOUR = "four", YACHT = "yacht",
            FULL_HOUSE = "full-house", SMALL_STRAIGHT = "small-straight", BIG_STRAIGHT = "big-straight", NONE = "none";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int[] input = new int[5];
            for (int j = 0; j < 5; j++) input[j] = sc.nextInt();
            sb.append(checkCombination(sortArray(input)));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static String checkCombination(int[] a) {
        if (a[0] == a[4]) return YACHT;
        if (a[0] == a[3] || a[1] == a[4]) return FOUR;
        if (a[0] == a[2] || a[1] == a[3] || a[2] == a[4]) {
            if (a[0] == a[1] && a[3] == a[4]) return FULL_HOUSE;
            else return THREE;
        }
        if (a[0] == a[1] && a[2] == a[3] || a[1] == a[2] && a[3] == a[4] || a[0] == a[1] && a[3] == a[4])
            return TWO_PAIRS;
        if (a[0] == a[1] || a[1] == a[2] || a[2] == a[3] || a[3] == a[4]) return PAIR;
        int sum = 0;
        for (int v : a) sum += v;
        switch (sum) {
            case 15:
                return SMALL_STRAIGHT;
            case 20:
                return BIG_STRAIGHT;
        }
        return NONE;
    }

    private static int[] sortArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int max = 0, maxPos = array.length - 1;
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > max) {
                    max = array[j];
                    maxPos = j;
                }
            }
            if (maxPos != array.length - i - 1) {
                array[maxPos] = array[array.length - i - 1];
                array[array.length - i - 1] = max;
            }
        }
        return array;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
