import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 21.10.2016.
 *
 * Sofia works as a sales manager in the net of retailers.

 Now the company is going to launch several brand-new items to their shops. The only trouble is that the name for new
 brands is yet to be choosen.

 Sofia is ordered to invent these names. However, many good words are already used (like Apple, Ikea, Gillet). So she
 asked you to write a program which can generate a collection of funny words. She then will be able to read the list
 leisurely and pick some for brand names.

 Let us work by following algorithm:

 Let the words have arbitrary amount of letters, but letters at odd positions (1, 3, 5, ...) should be consonant, while
 letters ad even positions (2, 4, 6, ...) - like galaban, fanero - since such words are guaranteed to be easy to pronounce.
 Let agree that consonant letters are bcdfghjklmnprstvwxz and vowels are aeiou (note q and y are skipped).
 Implement simple Linear Congruential Generator with parameters A = 445, C = 700001, M = 2097152 - and initial value X0
 for sequence (i.e. seed) would be given to you as input data.
 To generate word consisting of N letters, generate the same amount of next random numbers with this generator, for
 example with X0 = 0 and N = 4 you'll get numbers 700001, 1821950, 1967079, 1537772.
 convert each of these random values to letter by taking modulo 19 for consonants or 5 for vowels and selecting the
 letter from the strings above (see step 2) simply by index.
 For example, if X0 = 0 and we are to generate the word of 4 letters, we have the following calculations:

 Random Value       Letter Index        Letter
 700001         700001 % 19 = 3        F
 1821950        1821950 % 5  = 0        A
 1967079        1967079 % 19 = 9        M
 1537772        1537772 % 5  = 2        I
 So resulting word is fami.

 Surely, we can generate many words without reseting our random generator, since this generator has a period of about
 2 million values.

 Input data will contain number of words to generate at first line and seed value X0 for random generator.
 Next line will contain lengths of words which should be generated, separated with spaces.
 Answer should contain the words you generated, also separated by space.

 Example:

 input data:
 3 0
 4 5 6

 answer:
 fami wovaw kelasi
 Another example:

 input data:
 4 2014
 9 9 9 9

 answer:
 foravanad zibecefeb wagabenip wedivonow


 */
public class FunnyWordsGenerator {
    private static final char[] CONSONANTS = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'r', 's', 't', 'v', 'w', 'x', 'z'};
    private static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int x0 = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int[] randoms = generateRandoms(x0, sc.nextInt());
            x0 = randoms[randoms.length - 1];
            sb.append(generateWord(randoms));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static String generateWord(int[] randoms) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < randoms.length; i++) {
            sb.append((i + 1) % 2 == 0 ? VOWELS[randoms[i] % 5] : CONSONANTS[randoms[i] % 19]);
        }
        return sb.toString();
    }

    private static int[] generateRandoms(int x, int n) {
        int a = 445, c = 700001, m = 2097152, count = 0;
        int[] res = new int[n];
        while (count != n) {
            x = (a * x + c) % m;
            res[count] = x;
            count++;
        }
        return res;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
