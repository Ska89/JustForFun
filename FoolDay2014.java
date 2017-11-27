import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 10.09.2016.
 *
 *
 * Today I wanted to create new task and found it is April 1 2014 - the Fool's Day when people are trying to overjoke each other.

 So here is a small programming problem without the problem statement. Nevertheless you can do it! Good luck! :)

 Example:

 input data:
 5
 1 2
 1 2 3
 2 3 4
 2 4 6 8 10
 7 11 19

 answer:
 5 14 29 220 531


 */
public class FoolDay2014 {
    public static void main (String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(sumSQR(sc.nextLine()));
            if (i < count-1) {
                sb.append(" ");
            }
        }
        sc.close();
        printResult(sb);
    }

    private static int sumSQR(String s) {
        StringBuilder sb = new StringBuilder(s);
        int sum = 0;
        int val;
        while (sb.length() > 0){
            int index = sb.indexOf(" ");
            if (index == -1) {
                val = Integer.parseInt(sb.toString());
                sum += val*val;
                sb.delete(0, sb.length());
            }
            else {
                val = Integer.parseInt(sb.substring(0, index));
                sum += val*val;
                sb.delete(0, index+1);
            }
        }
        return sum;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
