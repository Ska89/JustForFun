import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 14.08.2016.
 *
 * From this problem we will learn a popular programming trick used in many variants of statistic calculations.
 * Imagine that some forester is trying to count pines, firs and birches on the some section of wood. He can go through
 * this section three times, counting only pines on first pass, only firs on the second and only birches on the third.
 * More efficient way is to make only one pass through wood and for each tree add a dot to one of tree pages in his
 * notebook - the first page for pines, next for firs and last for birches. That is the idea of counting similar elements
 * in the sequence using array of counters (instead of notebook).
 * Here is an array of length M with numbers in the range 1 ... N, where N is less than or equal to 20. We are to go
 * through it and count how many times each number is encountered.
 * I.e. it is like Vowel Count task, but we need to maintain more than one counter. Be sure to use separate array for
 * them, do not create a lot of separate variables, one for each counter.
 * Input data contain M and N in the first line.
 * The second (rather long) line will contain M numbers separated by spaces.
 * Answer should contain exactly N values, separated by spaces. First should give amount of 1-s, second - amount
 * of 2-s and so on.
 * Example:
 * data input:
 * 10 3
 * 3 2 1 2 3 1 1 1 1 3
 * answer:
 * 5 2 3
 *
 */
public class ArrayCounters {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] input = new int[m];
        for (int i = 0; i < m; i++)
            input[i] = sc.nextInt();
        sc.close();
        printResult(calculateCounts(input, n));
    }

    private static int[] calculateCounts(int[] input, int n) {
        int[] values = new int[n];
        for (int i = 0; i < n; i++)
            values[i] = i + 1;
        int[] counts = new int[n];
        for (int val : input)
            for (int j = 0; j < n; j++)
                if (val == values[j]) counts[j] += 1;
        return counts;
    }

    private static void printResult(int[] res) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int r : res) {
            sb.append(r);
            count++;
            if (count < res.length) sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
