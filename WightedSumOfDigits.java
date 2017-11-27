import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 07.08.2016.
 *
 * This program resembles more complex algorithms for calculation CRC and other checksums and also hash-functions
 * on character strings. Besides it will provide you with one more exercise on splitting values to decimal digits.
 * You may want to try Sum of Digits before this one.

 Let us calculate sum of digits, as earlier, but multiplying each digit by its position (counting from the left,
 starting from 1). For example, given the value 1776 we calculate such weighted sum of digits (let us call it "wsd") as:

 wsd(1776) = 1 * 1 + 7 * 2 + 7 * 3 + 6 * 4 = 60
 Input data will give the number of test-cases in the first line.
 Values themselves are in the second line. For each of these values you are to calculate weighted sum of digits.
 Answer: as usually, put results in one line, separating them with spaces.

 Example:

 input data:
 3
 9 15 1776

 answer:
 9 11 60


 */
public class WightedSumOfDigits {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(calculateWeightedSumOfDigits(sc.nextInt()));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static int calculateWeightedSumOfDigits(int input) {
        int d = input, count = 0;
        while (d != 0) {
            d /= 10;
            count++;
        }
        int res = 0;
        for (int i = count; i > 0; i--) {
            res += input % 10 * i;
            input /= 10;
        }
        return res;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
