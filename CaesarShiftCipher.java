import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 10.09.2016.
 *
 * If you feel this problem too easy for you, try Caesar Cipher Cracker instead!
 * Cryptography is one of most interesting branches of programming. Studying its algorithms usually begins with the simple method named after famous Roman emperor Julius Caesar who used it for communicating his military secrets (and perhaps for love letters to Cleopatra).
 * We will practice deciphering encrypted messages in this problem.
 * The idea of the algorithm is simple. Each letter of the original text is substituted by another, by the following rule:
 * find the letter (which should be encrypted) in the alphabet;
 * move K positions further (down the alphabet);
 * take the new letter from here;
 * if "shifting" encountered the end of the algorithm, continue from its start.
 * For example, if K = 3 (shift value used by Caesar himself), then A becomes D, B becomes E, W becomes Z and Z becomes C and so on, according to the following table:
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 * | | | | | | | | | | | | | | | | | | | | | | | | | |
 * V V V V V V V V V V V V V V V V V V V V V V V V V V
 * D E F G H I J K L M N O P Q R S T U V W X Y Z A B C
 * So if the source message was VENI VIDI VICI then after encoding it becomes YHQL YLGL YLFL.
 * On the other hand encrypted message should be "shifted back" to decode it - or shifted by 26 - K which is the same.
 * So if we have encoded message HYHQ BRX EUXWXV, we can apply shift of 26 - K = 26 - 3 = 23 and find the original text to be EVEN YOU BRUTUS.
 * Input data will contain two integers - the number of lines of encrypted text and the value of K.
 * The following lines will contain encrypted text, consisting of capital latin letters A ... Z, each line is terminated with a dot . which should not be decoded. Answer should contain the decrypted message (in a single line, no line splitting is needed).
 * Example:
 * input data:
 * 2 3
 * YHQL YLGL YLFL.
 * HYHQ BRX EUXWXV.
 * answer:
 * VENI VIDI VICI. EVEN YOU BRUTUS.
 */
public class CaesarShiftCipher {
    private static final char[] ALPHABET = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public static void main (String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.next());
        int k = Integer.parseInt(sc.next());
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            String s = sc.nextLine();
            sb.append(decryptMessage(s, k));
            if (i < count-1) {
                sb.append(" ");
            }
        }
        sc.close();
        printResult(sb);
    }

    private static String decryptMessage(String s, int k) {
        char[] array = s.toCharArray();
        for (int i=0; i<array.length-1; i++) {
            if (array[i] != ' ') {
                for (int j = 0; j < ALPHABET.length; j++) {
                    if (array[i] == ALPHABET[j]) {
                        if (j >= k) {
                            array[i] = ALPHABET[j - k];
                            break;
                        } else {
                            array[i] = ALPHABET[ALPHABET.length - k + j];
                            break;
                        }
                    }
                }
            }
        }
        return String.valueOf(array);
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
