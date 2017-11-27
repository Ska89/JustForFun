import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 14.08.2016.
 *
 *
 * Quite a simple task - just to start learning strings...

 Input data will contain a single string of small latin letters and few spaces.
 Answer should contain the string of the same length with the same characters but in reverse order.

 Example:

 input data:
 four score and seven years ago

 answer:
 oga sraey neves dna erocs ruof
 Though some languages especially functional has built-in function for this, please try perform it on your own and
 'in-place' i.e. moving characters of the same string instead of copying them to the new one.
 */
public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        sc.close();
        char res [] = a.toCharArray();
        for (int i=res.length-1; i>=0; i--){
            System.out.print(res[i]);
        }
    }
}
