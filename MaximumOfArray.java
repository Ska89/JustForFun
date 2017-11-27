import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 07.08.2016.
 *
 *
 * This problem introduces popular algorithm of the "linear search", which should be learnt thoroughly as it is often
 * used in programming more complex tasks (sorting etc.)

 Very common operation on sequence of values, or arrays is to find its extremal value - maximum or minimum.
 To achieve this one need to store current maximum (or minimum respectively) in a separate variable, and then run
 through array, comparing each of its elements to this variable. Whenever next value is greater than this temporary
 variable, this value should be copied into it (as a new maximum).

 At the end of the pass this temporary variable will hold the extremum value.

 Input data will give you exactly 300 numbers in a single line.
 Answer should contain maximum and minimum of these values, separated by space.

 Example:

 input data:
 1 3 5 7 9 11 ... 295 297 299 300 298 296 ... 12 10 8 6 4 2

 answer:
 300 1

 */
public class MaximumOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputData = sc.nextLine();
        sc.close();
        System.out.println(getMaxMin(inputData));
    }
    private static String getMaxMin(String inputData){
        String inData [] = inputData.split(" ");
        int inDataInt[] = new int[300];
        for (int i=0; i<300; i++){
            inDataInt[i]=Integer.parseInt(inData[i]);
        }

        int min=inDataInt[0];
        int max=inDataInt[0];
        for (int i=1; i<300; i++){
            min=Math.min(min, inDataInt[i]);
            max=Math.max(max, inDataInt[i]);
        }
        return max+" "+min;
    }
}
