import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 20.10.2016.
 *
 * A group of pirates was lucky to lay their hands on the map of the Treasure Island.
 * To their disappointment the map does not contain a vague drawings with a small black cross - but instead just several
 * lines like the following:
 * at the southern beach of the Island find the pole stuck into the sand with the plaque Start attached;
 * turn azimuth 50 and go 300 feet;
 * proceed 500 feet by azimuth 270;
 * stride 150 feet more by azimuth 300;
 * dig here!
 * Pirates read in Wikipedia that azimuth 0 is the direction to the North, azimuth 90 is the direction to the East
 * and so on.
 * However, they use a kind of GPS-navigator in place of compass. Instead of directions the device can show coordinates
 * or offsets in feets.
 * So pirates need to solve the following problem: suggesting that the point of "the pole with the plaque Start" is
 * the origin of coordinate system with Y axis pointing to the North and X axis pointing to the East - what are the
 * coordinates of the treasure point?
 * Input data will be in format close to the directions inscribed on a map:
 *
 * The first line contains words Stand at the pole with the plaque START - you can safely ignore this.
 * Next lines contain words go X feet by azimuth Y - you are to extract numbers from them.
 * Last line contains phrase Dig here!
 * Answer should contain coordinates of the point where the Treasure is hidden, rounded to closest integers.
 * Example:
 * input data:
 * Stand at the pole with the plaque START
 * go 140 feet by azimuth 332
 * go 460 feet by azimuth 78
 * Dig here!
 * answer:
 * 384 219
 */
public class AzimuthAtTreasureIsland {
    public static void main (String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> inputList = new ArrayList<String>();
        String s;
        do {
            s = sc.nextLine();
            inputList.add(s);
        } while (!s.equals("Dig here!"));
        sc.close();
        printResult(calculateCoordinates(inputList));
    }

    private static int[] calculateCoordinates(ArrayList<String> list) {
        double xRes = 0, yRes = 0;
        for (int i=1; i<list.size()-1; i++) {
            String[] str = list.get(i).split(" ");
            int dist = Integer.parseInt(str[1]);
            int azim = Integer.parseInt(str[5]);
            double xC = (double) dist*Math.cos(Math.toRadians(azim));
            double yC = (double) dist*Math.sin(Math.toRadians(azim));
            xRes += xC;
            yRes += yC;
        }
        return new int[] {(int) Math.round(yRes), (int) Math.round(xRes)};
    }

    private static void printResult(int[] res) {
        System.out.println(res[0] + " " + res[1]);
    }
}
