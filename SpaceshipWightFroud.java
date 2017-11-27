import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 18.08.2016.
 *
 *
 * This problem is very similar to one given at Facebook Hackercup event in Jan 2015 (qualification, problem #1).
 * We offer it to you so you can get better acquainted with problems of this popular contest and have greater motivation
 * to participate in future years.

 captain with a book weighting a rocket
 When merchant spaceship is fully loaded its total mass is expressed by long integer number, like 31415926. The Ship's
 Master want to tweak this value in documents to increase his profit, because both tax to be paid for the ship and the
 wages he will receive for jounrney are proportional to this mass.

 He discovered that if he only swaps two digits (not necessarily adjacent) - no one will notice this.

 So he want to know two things:

 to which smallest value this number could be transformed by such a swap, to decrease tax he should pay;
 also to what largest value the number could be transformed, to increase the wages he is going to receive.
 He can perform only one swap - and there is limitation that resulting value should not start with 0 (so its length is
 decreased which could be easily noticed).

 For the sample value given above the smallest value is 11435926 and the largest is 91415326.

 Note that input values will never start with 0 - thanks to Nicolas Patrois for pointing out this bug!

 Input data will have the total quantity of test cases in the first line.
 Next lines will contain a single integer each in hexadecimal (no longer than 30 digits, first of them is non-zero).
 Answer should contain a pair of min and max values for each mass in the input.

 Example:

 input data:
 3
 302A
 10
 31415926

 answer:
 203A A023 10 10 11435926 91415326


 */
public class SpaceshipWightFroud {

    private static StringBuilder sb;

    public static void main(String[] args) {
        sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++)
            findResult(sc.nextLine());
        sc.close();
        printResult();
    }

    private static void findResult(String s) {
        int[] res;
        char[] array;
        for (int i = 0; i < 2; i++) {
            array = s.toCharArray();
            res = i == 0 ? findMin(s, 0) : findMax(s, 0);
            if (res[0] != res[1])
                array[res[1]] += array[res[0]] - (array[res[0]] = array[res[1]]);
            addToResult(array);
        }
    }

    private static int[] findMin(String s, int shift) {
        if (s.length() <= 1 || (s.length() == 2 && s.charAt(1) == '0')) return new int[]{0, 0};
        char[] array = s.toCharArray();
        int pos = 0;
        char min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= min && !(shift == 0 && array[i] == '0')) {
                min = array[i];
                pos = i;
            }
        }
        return (pos == 0 || (array[pos] == array[0] && shift == 0)) && array.length > shift ?
                findMin(s.substring(1), shift + 1) : new int[]{pos + shift, shift};
    }

    private static int[] findMax(String s, int shift) {
        if (s.length() <= 1) return new int[]{0, 0};
        char[] array = s.toCharArray();
        int pos = 0;
        char max = array[pos];
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= max) {
                max = array[i];
                pos = i;
            }
        }
        return (pos == 0 || (array[pos] == array[0] && shift == 0)) && array.length > shift ?
                findMax(s.substring(1), shift + 1) : new int[]{pos + shift, shift};
    }

    private static void addToResult(char[] array) {
        sb.append(String.format("%s ", new String(array)));
    }

    private static void printResult() {
        System.out.println(sb.toString().trim());
    }
}
