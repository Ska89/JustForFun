import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 28.08.2016.
 *
 * To rotate string by K characters means to cut these characters from the beginning and transfer them to the end.
 * If K is negative, characters, on contrary should be transferred from the end to the beginning.

 Input data will contain the number of test-cases in the first line.
 Following lines will contain number K and some string S separated by space - one pair in each line.
 String S will contain only small latin letters. K will not exceed half the length of S by absolute value.
 Answer should contain strings rotated in accordance with the rule above, separated by spaces. For example:

 input data:
 2
 3 forwhomthebelltolls
 -6 verycomplexnumber

 answer:
 whomthebelltollsfor numberverycomplex
 The task could be easily solved by creating new instance of string concatenating two substrings. However,
 if you want more serious challenge, you are encouraged to perform rotation "in-place", moving bytes of original
 string (i.e. without allocating memory for new instance). This could be done with the help of a loop and only one
 temporary variable.


 */
public class RotateString {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int k = Integer.parseInt(sc.next());
            String s = sc.next();
            sb.append(rotateString(k, s));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static String rotateString(int k, String s) {
        char tmp;
        char[] array = s.toCharArray();
        if (k > 0) {
            for (int i = 0; i < k; i++) {
                tmp = array[0];
                System.arraycopy(array, 1, array, 0, array.length - 1);
                array[array.length - 1] = tmp;
            }
        } else {
            k = Math.abs(k);
            for (int i = 0; i < k; i++) {
                tmp = array[array.length - 1];
                System.arraycopy(array, 0, array, 1, array.length - 2 + 1);
                array[0] = tmp;
            }
        }
        return String.valueOf(array);
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
