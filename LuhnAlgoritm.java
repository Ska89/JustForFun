import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 25.10.2016.
 *
 * Bookkeeper of the Abbey, Brother Kyprian just have discovered a nasty trouble! He is to pay small rewards to
 * volunteers who worked at the farm during summer - but the bank rejected to process most of payments!

 Bank card numbers of these workers were written too carelessly and it seems that each of the numbers contain one of
 two errors:

 either some of the digits could not be recognized;
 or some pair of adjacent digits were mistakenly swapped.
 However, Brother Kyprian just found wikipedia article about algorithm which is used to calculate checksum of the bank
 card numbers. Below the summary of this method is given.

 Algorithm
 The method is named after Hans Peter Luhn who have proposed it. The main idea of the algorithm is to check most common
 types of mistakes - and on the other hand to be simple enough, i.e:

 to be so simple that it could be calculated with (or without) paper and pencil, or with mechanic device;
 detect mistake in any single digit;
 detect accidental swap of two adjacent digits.
 And here are the steps of the algorithm:

 We should sum up all digits starting from the end.
 However each second digit (2nd from the end, 4th from the end and so on) is not added "as is" - instead it is
 multiplied by two (if the result contains more than one digit - sum its digits - or simply subtract 9 from it).
 If result is not a multiple of 10, then the number is incorrect.
 For example if we have a number 4123 1759 0498 1754 then we should sum up the following values (going from the end):

 4+(5*2-9)+7+(1*2) + 8+(9*2-9)+4+(0*2) + 9+(5*2-9)+7+(1*2) + 3+(2*2)+1+(4*2) = 70
 Since 70 is divisible by 10 then probably the number is valid.

 To create correct number usually the last digit is really check digit - i.e. it does store any business information
 but instead is chosen so that the whole number gives a proper checksum.

 Problem statement
 So please help Brother Kyprian to fix a list of bank card numbers. Some of them just miss one of digits and you should
 restore this digit. Others have a pair of adjacent digits swapped - you are to find the leftmost pair which,
 if swapped, makes valid card number.

 All the card numbers would be 16 digits long (this is the most common length even in fairytales.

 Input data contain a list of workers who have their card numbers incorrect.
 Next lines contain a single card number each. If the number contains "?" (question mark) instead of some digit -
 this digit should be restored. If all digits are present, then "swap-error" should be fixed.
 Answer should contain a list of "fixed" card numbers.

 Example:

 input data:
 4
 ?942682966937054
 1217400151414995
 2146133934?67114
 2553514623364925

 answer:
 3942682966937054 1217040151414995 2146133934667114 2553514623369425
 */
public class LuhnAlgoritm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(arrayToString(verifyCardNumber(sc.nextLine())));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static int[] verifyCardNumber(String s) {
        int[] array = new int[16];
        if (s.contains("?")) {
            int xPos = 0;
            for (int i = 0; i < 16; i++) {
                if (s.charAt(i) == '?') xPos = i;
                else array[i] = Character.getNumericValue(s.charAt(i));
            }
            while (!checkCardNumber(array)) {
                array[xPos]++;
            }
        } else {
            for (int i = 0; i < 16; i++)
                array[i] = Character.getNumericValue(s.charAt(i));
            int tmp;
            for (int i = 1; i <= 16; i++) {
                tmp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = tmp;
                if (checkCardNumber(array)) return array;
                array[i - 1] = array[i];
                array[i] = tmp;
            }
        }
        return array;
    }

    private static boolean checkCardNumber(int[] array) {
        int checkSum = 0;
        for (int i = 15; i >= 0; i--) {
            checkSum += array[i];
            if (i % 2 == 0) {
                checkSum += array[i];
                if (array[i] > 4) checkSum -= 9;
            }
        }
        return checkSum % 10 == 0;
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i : array) sb.append(i);
        return sb.toString();
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
