import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 18.08.2016.
 *
 * The word or whole phrase which has the same sequence of letters in both directions is called a palindrome.
 * Here are few examples:

 Stats
 Amore, Roma
 No 'x' in Nixon
 Was it a cat I saw?
 As you see, case of the letters is ignored. Spaces and punctuations are ignored too.

 Your goal in this programming exercise is to determine, whether the phrase represents a palindrome or not.

 Input data contains number of phrases in the first line.
 Next lines contain one phrase each.
 Answer should have a single letter (space separated) for each phrase: Y if it is a palindrome and N if not.

 Example:

 input data:
 3
 Stars
 O, a kak Uwakov lil vo kawu kakao!
 Some men interpret nine memos

 answer:
 N Y Y


 */
public class Palindromes {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(isPalindrome(prepareStringToCheck(sc.nextLine())) ? "Y" : "N");
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static String prepareStringToCheck(String s) {
        return s.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }

    private static boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        if (s.charAt(0) == s.charAt(s.length() - 1))
            return isPalindrome(s.substring(1, s.length() - 1));
        return false;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res.toString());
    }
}
