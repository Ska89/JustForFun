import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 18.08.2016.
 *
 * Two bicyclist start moving from different cities heading to meet each other somewhere in the middle (not exactly
 * since they travel with different speed).
 * The road is laid in straight line between two cities.
 * You will be given the distance between cities S (in kilometers) and speed values for two bicyclists
 * (A and B in kilometers per hour). Your task is to find their meeting point (its distance from the first of cities).
 * Input data will have the number of test-cases in the first line.
 * Next lines will contain three values each S A B.
 * Answer should contain the distances between first city and rendezvous point (i.e. distance travelled by first
 * cyclist before they meet), separated with spaces.
 * Example:
 * input data:
 * 2
 * 10 1 1
 * 20 1 2
 * answer:
 * 5 6.66666667
 * Note: the floating point values should have precision 10e-7 or better


 */
public class BicycleRace {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(calculateDistance(sc.nextInt(), sc.nextInt(), sc.nextInt()));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static double calculateDistance(int s, int a, int b) {
        return (double) a * ((double) s / (a + b));
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
