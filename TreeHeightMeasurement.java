import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 16.10.2016.
 */
public class TreeHeightMeasurement {
    public static void main (String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int d = Integer.parseInt(sc.next());
            double b = Double.parseDouble(sc.next());
            sb.append(calculateTreeHeight(d, b));
            if (i < count-1) {
                sb.append(" ");
                sc.nextLine();
            }
        }
        sc.close();
        printResult(sb);
    }

    private static int calculateTreeHeight(int d, double b) {
        return (int) Math.round(d*Math.tan(Math.toRadians(b-90)));
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
