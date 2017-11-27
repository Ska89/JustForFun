import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 11.09.2016.
 *
 *
 * As you probably know, all values inside a computer are represented in binary system. In this simple task you are to
 * write a program which counts the number of non-zero bits in a given value.
 * We are using 32-bit integer values, so there should be from 0 to 32 non-zero bits.
 * Please note that unlike most languages Python pretends that numbers are infinite-length (this will not prevent you
 * from solving this task, though some of methods usable for other languages may not work as expected).
 * For example:
 * value             binary                count
 * 1   00000000000000000000000000000001      1
 * 100   00000000000000000000000001100100      3
 * -1   11111111111111111111111111111111     32
 * Input data will contain a number of values to process.
 * Next line will contain the values themselves, each in range -2 000 000 000 .. 2 000 000 000.
 * Answer should contain the counts of bits set to 1 for each of values, separated by spaces.
 * Example:
 * input data:
 * 3
 * 1 100 -1
 * answer:
 * 1 3 32
 */
public class BitCount {
    private static int getUnit(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String inputData = sc.nextLine();
        sc.close();

        String workArray[] = inputData.split(" ");
        String result = "";
        for (int i = 0; i < num; i++) {
            result += getUnit(Integer.parseInt(workArray[i])) + " ";
        }
        System.out.println(result);
    }
}
