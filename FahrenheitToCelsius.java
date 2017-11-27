import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 07.08.2016.
 *
 *
 *
 This programming exercise is roughly the same as counting sums in loop, but it needs bit more calculations.

 fahrenheit and celsius
 Note: the problem Rounding explains the rounding algorithm which is used in this task.

 There are two widespread systems of measuring temperature - Celsius and Fahrenheit. First is quite popular in Europe
 and second is well in use in United States for example.

 By Celsius scale water freezes at 0 degrees and boils at 100 degrees. By Fahrenheit water freezes at 32 degrees and
 boils at 212 degrees. You may learn more from wikipedia on Fahrenheit. Use these two points for conversion of other
 temperatures.

 You are to write program to convert degrees of Fahrenheit to Celsius.

 Input data contains N+1 values, first of them is N itself (Note that you should not try to convert it).
 Answer should contain exactly N results, rounded to nearest integer and separated by spaces.

 Example:

 data:
 5 495 353 168 -39 22
 answer:
 257 178 76 -39 -6
 Please note that first 5 is not a temperature, but the amount of values to convert!
 */
public class FahrenheitToCelsius {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        printResult(convertFahrenheitToCelsius(fillArrayListFromString(sc.nextLine())));
        sc.close();
    }

    private static String convertFahrenheitToCelsius(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append((int) Math.round((double) 5 / 9 * (array[i] - 32)));
            if (i < array.length - 1) result.append(" ");
        }
        return result.toString();
    }

    private static int[] fillArrayListFromString(String s) {
        StringBuilder sb = new StringBuilder(s);
        int countIndex = sb.indexOf(" ");
        int count = Integer.parseInt(sb.substring(0, countIndex));
        sb.delete(0, countIndex + 1);
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            int index = sb.indexOf(" ");
            if (index == -1) {
                array[i] = Integer.parseInt(sb.toString());
                sb.delete(0, sb.length());
            } else {
                array[i] = Integer.parseInt(sb.substring(0, index));
                sb.delete(0, index + 1);
            }
        }
        return array;
    }

    private static void printResult(String result) {
        System.out.println(result);
    }
}
