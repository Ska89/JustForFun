import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 07.10.2016.
 *
 * If you know the old game Bulls and Cows, this programming problem will look familiar to you.

 Andrew and Peter play the code-guessing game. Andrew chooses a secret number consisting of 3 digits. Peter tries to
 guess it, proposing several values, one by one.

 For each guess Andrew should answer how many digits are correct - i.e. are the same in the proposed value and in his
 secret number - and are placed in the same position. For example, if secret number is 125 and Peter calls 523, then
 Andrew answers with 1. Here is the sample of the game:

 Andrew chooses a secret number 846

 Peter's guess             Andrew's answer
 402                        0
 390                        0
 816                        2
 848                        2
 777                        0
 815                        1
 846                        3
 So Peter have guessed correct number after 6 attempts.

 You are to write program which reads guesses given by Peter (except the last) and prints out the secret number choosen
 by Andrew. It is guaranteed that exactly one solution exists.

 Input data will contain number of guesses in the first line.
 Then answers with attempts will follow - each contains the number told by Peter and the answer given by Andrew.
 In contrast with examples numbers will be of 4 digits.
 Answer should contain the secret number (also 4 digits). See example:

 input data:
 6
 402 0
 390 0
 816 2
 848 2
 777 0
 815 1

 answer:
 846
 Here we use 3-digit values for brevity, but the algorithm is the same.
 */
public class CodeGuesser {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < count; i++)
            map.put(sc.nextInt(), sc.nextInt());
        sc.close();
        printResult(guessCode(map));
    }

    private static String guessCode(HashMap<Integer, Integer> map) {
        //arrays of all possible digits for each place in result code
        boolean[] arrayFirst = {true, true, true, true, true, true, true, true, true, true};
        boolean[] arraySecond = {true, true, true, true, true, true, true, true, true, true};
        boolean[] arrayThird = {true, true, true, true, true, true, true, true, true, true};
        boolean[] arrayFourth = {true, true, true, true, true, true, true, true, true, true};
        boolean[][] allDigits = {arrayFirst, arraySecond, arrayThird, arrayFourth};

        //set false for all digits from absolutely incorrect guesses
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() == 0) {
                int key = entry.getKey();
                for (int i = 0; i < allDigits.length; i++) {
                    allDigits[i][getDigitByPosition(key, i + 1)] = false;
                }
                iterator.remove();
            }
        }

        //init result digits array
        int[] resDigits = {-1, -1, -1, -1};

        //check bool arrays, if true count in array == 1 -> it is an answer digit
        for (int i = 0; i < allDigits.length; i++)
            if (countTrue(allDigits[i]) == 1)
                resDigits[i] = findTruePosition(allDigits[i]);

        //iterate guesses with 1,2,3 correct digits. if false count == 4-correct count
        //(true count == correct count) -> these digits are correct answers
        for (int m = 1; m < 4; m++) {
            iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getValue() == m) {
                    int key = entry.getKey();
                    int[] digits = new int[4];
                    int fCount = 0;
                    for (int i = 0; i < 4; i++) {
                        digits[i] = getDigitByPosition(key, i + 1);
                        if (!allDigits[i][digits[i]]) fCount++;
                    }

                    if (fCount == 4 - entry.getValue()) {
                        for (int i = 0; i < 4; i++)
                            if (allDigits[i][digits[i]] && resDigits[i] < 0)
                                resDigits[i] = digits[i];
                        iterator.remove();
                    }
                }
            }
        }

        //iterate the rest of guesses until all digits will be found
        int k = 0;
        while (map.size() > 0 && !checkForAllDigitsPresent(resDigits) && k < 10) {
            iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                int value = entry.getValue();
                int key = entry.getKey();
                boolean[] checkGuess = {true, true, true, true};
                int[] digits = new int[4];
                int fCount = 0;

                for (int i = 0; i < 4; i++) {
                    digits[i] = getDigitByPosition(key, i + 1);
                    if (resDigits[i] >= 0 && digits[i] != resDigits[i]) {
                        checkGuess[i] = false;
                        fCount++;
                    } else if (!allDigits[i][digits[i]]) {
                        checkGuess[i] = false;
                        fCount++;
                    }
                }

                if (fCount == 4 - value)
                    for (int i = 0; i < 4; i++)
                        if (checkGuess[i] && resDigits[i] < 0)
                            resDigits[i] = digits[i];
                iterator.remove();
                k++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : resDigits) sb.append(i);
        return sb.toString();
    }

    private static int getDigitByPosition(int value, int n) {
        n = 4 - n;
        for (int i = 1; i <= n; i++) value /= 10;
        return value % 10;
    }

    private static boolean checkForAllDigitsPresent(int[] array) {
        for (int i : array) if (i < 0) return false;
        return true;
    }

    private static int countTrue(boolean[] array) {
        int count = 0;
        for (boolean b : array) if (b) count++;
        return count;
    }

    private static int findTruePosition(boolean[] array) {
        for (int i = 0; i < array.length; i++) if (array[i]) return i;
        return -1;
    }

    private static void printResult(String res) {
        System.out.println(res);
    }
}
