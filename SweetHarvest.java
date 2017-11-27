import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 03.09.2016.
 *
 * Here is a variation of another popular task for practicing dynamic programming approach (though of course precise
 * algorithm is not explained by these words).

 11
 5
 3
 17
 2
 13
 19
 7
 The Rabbit is going to cross the river. There is a straight chain of tiny isles across the flow and the animal should
 jump from one to another because it surely could not swim.

 At each of the isles there are some candies. When the Rabbit arrives to the new isle, it collects all the candies here.

 However, the Rabbit could not jump directly to the next isle in the chain - it just is too strong to make short jumps.
 So, instead, it can jump over the one or two isles (i.e. from the 1st for example to 3rd or 4th but not to 2nd or 5th
 and further). Also the Rabbit could not jump back.

 You can see the sample of the Rabbit's path on the drawing above. It visits 1st, 3rd, 6th and 8th isles and collects:

 11 + 3 + 13 + 7 = 34
 the amount of 34 candies. Obviously he could do better if the path is chosen more wisely.

 Your task is to choose the best path for Rabbit over the given chain of isles - i.e. to maximize the amount of the
 candies collected. Note that Rabbit starts from 1st isle and finishes either on the Nth or (N-1)th where N is the total
 number of isles (because from these two it will necessarily jump immediately to the other bank).

 Input data will contain the number of test-cases in the first line.
 Next lines contain one test-case each - i.e. one chain of isles, described by the array of numbers - amounts of
 candies at each isle.
 Answer should contain the maximum possible amount of candies gathered for each test case.

 Example:

 input data:
 2
 11 5 3 17 2 13 19 7
 9 7 12 7 16 3 7 17 14 13 4 6 11 6 3 3 5 4 11 3 15 12 14 2 15 19 11 12

 answer:
 48 157


 */
public class SweetHarvest {
    private static int maxCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int[] array = stringToArray(sc.nextLine());
            maxCount = 0;
            findABetterWay(array, 0, 0);
            sb.append(maxCount);
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static void findABetterWay(int[] array, int index, int count) {
        count += array[index];
        if (count > maxCount) maxCount = count;
        if (index + 2 < array.length) findABetterWay(array, index + 2, count);
        if (index + 3 < array.length) findABetterWay(array, index + 3, count);
    }

    private static int[] stringToArray(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 0) {
            int index = sb.indexOf(" ");
            if (index == -1) {
                list.add(Integer.parseInt(sb.toString()));
                break;
            } else {
                list.add(Integer.parseInt(sb.substring(0, index)));
                sb.delete(0, index + 1);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
