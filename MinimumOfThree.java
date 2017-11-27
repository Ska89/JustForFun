import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 07.08.2016.
 *
 *
 To have more practice with conditional statements we are going to write a program which uses complex condition.
 I.e. one if ... else statement could be (and should be) nested inside other to solve this problem.

 Several triplets of numbers are given to you. Your task is to select minimum among each of triplets.

 Input data will contain in the first line the number of triplets to follow.
 Next lines will contain one triplet each.
 Answer should contain selected minimums of triplets, separated by spaces.

 Example:

 data:
 3
 7 3 5
 15 20 40
 300 550 137

 answer:
 3 15 137
 */
public class MinimumOfThree {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(compareThreeIntsForMin(sc.nextInt(), sc.nextInt(), sc.nextInt()));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static int compareThreeIntsForMin(int a, int b, int c) {
        int ab = (a < b) ? a : b;
        return (ab < c) ? ab : c;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
