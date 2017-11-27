import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 07.08.2016.
 *
 * This is a simple problem to get introduced to string processing. We will be given several lines of text - and
 * for each of them we want to know the number of vowels (i.e. letters a, o, u, i, e, y). Note: that y is regarded as
 * vowel for purpose of this task.

 Though simple, this technic is important in cipher-breaking approaches. For example refer to Caesar Cipher Cracker
 problem.

 Input data contain number of test-cases in the first line.
 Then the specified number of lines follows each representing one test-case.
 Lines consist only of lowercase English (Latin) letters and spaces.
 Answer should contain the number of vowels in each line, separated by spaces.

 Example:

 input data:
 4
 abracadabra
 pear tree
 o a kak ushakov lil vo kashu kakao
 my pyx

 answer:
 5 4 13 2
 */
public class VowelCount {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(calculateMatchesCount(sc.nextLine()));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static int calculateMatchesCount(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).matches("[aouiey]")) count++;
        }
        return count;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
