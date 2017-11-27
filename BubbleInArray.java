import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 18.08.2016.
 *
 * This problem provides an exercise for learning core idea of infamous ordering algorithm - bubble sort - which we are supposed to learn a bit later.
 * Given integer array, we are to iterate through all pairs of neighbor elements, starting from beginning - and swap members of each pair where first element is greater than second.
 * For example, let us consider small array of elements 1 4 3 2 6 5, marking which pairs are swapped and which are not:
 * (1  4) 3  2  6  5  - pass
 * 1 (4  3) 2  6  5  - swap
 * 1  3 (4  2) 6  5  - swap
 * 1  3  2 (4  6) 5  - pass
 * 1  3  2  4 (6  5) - swap
 * 1  3  2  4  5  6  - end
 * This operation moves some greater elements right (to the end of array) and some smaller elements left (to the beginning).
 * What is the most important: the largest element is necessarily moved to the last position.
 * Input data contain sequence of elements of the array, all positive. After this value -1 follows to mark the end (it should not be included into an array).
 * Answer should contain two values - number of performed swaps and checksum of the array after processing (separated by spaces).
 * Checksum should be calculated with exactly the same method as in the task Array Checksum
 * Example:
 * input data:
 * 1 4 3 2 6 5 -1
 * answer:
 * 3 5242536
 */
public class BubbleInArray {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        MyObject myObject = sortBubble(stringToArray(sc.nextLine()));
        printResult(myObject.getIterations(), calculateChecksum(myObject.getArray()));
        sc.close();
    }

    private static int[] stringToArray(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        int index;
        while (sb.length() > 2) {
            index = sb.indexOf(" ");
            list.add(Integer.parseInt(sb.substring(0, index)));
            sb.delete(0, index + 1);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = list.get(i);
        return result;
    }

    private static MyObject sortBubble(int[] array) {
        int tmp, iterations = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < array[i]) {
                tmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = tmp;
                iterations++;
            }
        }
        return new MyObject(array, iterations);
    }

    private static long calculateChecksum(int[] array) {
        long result = 0;
        int seed = 113, limit = 10000007;
        for (int i : array) {
            result = (result + i) * seed;
            if (result > limit) result %= limit;
        }
        return result;
    }

    private static void printResult(int iterations, long checksum) {
        System.out.println(iterations + " " + checksum);
    }

    private static class MyObject {
        private static int[] array;
        private static int iterations;

        private MyObject(int[] array, int iterations) {
            MyObject.array = array;
            MyObject.iterations = iterations;
        }

        int[] getArray() {
            return array;
        }

        int getIterations() {
            return iterations;
        }
    }
}
