import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 18.08.2016.
 *
 *
 *
 After solving the task Bubble Sort we are supposed to learn about sorting arrays. Now we have a bit more complicated
 programming problem for you, since it is important to have practice in sorting and handling not only primitive values
 but also more complex objects.

 As previously, we are given an array of numbers. It should be sorted first (in non-decreasing order) - and then for
 each value its initial index should be printed (indexes start from 1).

 I.e., suppose we have an array 50 98 17 79 which after sorting becomes 17 50 79 98. Now:

 17 was at 3-rd place initially
 50 was at 1-st place initially
 79 was at 4-th place initially
 98 was at 2-nd place initially

 so result is
 3 1 4 2
 Initial data will contain array size at first line and array values itself in the second (integers separated by spaces).
 Answer should contain initial indexes of the array members after they are reordered by sorting.

 Example:

 input data:
 4
 50 98 17 79

 answer:
 3 1 4 2


 */
public class SortWithinIndexes {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = sc.nextInt();
        sc.close();
        printResult(sortArray(array));
    }

    private static int[] sortArray(int[] array) {
        int tmp;
        int[] sorted = new int[array.length];
        System.arraycopy(array, 0, sorted, 0, array.length);

        for (int i = 0; i < sorted.length; i++) {
            for (int j = 0; j < sorted.length - 1 - i; j++) {
                if (sorted[j + 1] < sorted[j]) {
                    tmp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = tmp;
                }
            }
        }

        int[] indexes = new int[array.length];
        for (int n = 0; n < sorted.length; n++) {
            for (int m = 0; m < array.length; m++) {
                if (sorted[n] == array[m]) {
                    indexes[n] = m + 1;
                    break;
                }
            }
        }
        return indexes;
    }

    private static void printResult(int[] res) {
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            if (i < res.length - 1) System.out.print(" ");
        }
    }
}
