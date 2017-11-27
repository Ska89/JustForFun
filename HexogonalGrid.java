import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 17.10.2016.
 *
 *
 * Many computer games are played by moving some pieces or heroes over a map or a field of some kind. There are two
 * popular kinds for geometry of such maps:

 rectangular grid - the field is tiled by rectangles or squares;
 hexagonal grid - the field is tiled by hexagons.
 Well-known game Heroes of Might and Magic for example utilized both variants - rectangular grid is used on the world
 map while riding between castles (with ability of diagonal movements), while hexagonal grid is used as a battle field
 in combat mode.

 Hexagonal tiling looks more beautiful for user, but the programming its geometry is slightly more tricky. That is what
 we are going to practice now.

 Problem statement

 Suppose the "hero" is placed at some cell of hexagonal grid. Then he can move in six directions. On the picture above X
 marks the initial cell and letters A, B, C, D, E, F - the possible movements for 1 step. A moves the hero directly to
 the right and other directions are named in the counter-clockwise order.

 You will be given a sequence of steps, performed by hero, each step described by a corresponding letter. You are to tell
 after all these steps, how far the hero is now from his initial position.

 We agree that the hero is always placed at the center of the cell and that distance between centers of two adjacent
 cells (i.e. sharing a side) is 1.0.

 Input data will contain number of test-cases in the first line.
 Next lines will contain the sequence of steps (one sequence per line) as a string of letters.
 Answer should contain the distances between starting and ending point for each of sequences, separated by spaces and
 with accuracy of 1e-7 at least.

 Example:

 input data:
 3
 AABF
 FEDCBA
 BCB

 answer:
 3.0 0.0 2.64575131


 */
public class HexogonalGrid {
    private static double[] xC;
    private static double[] yC;
    private static final char[] STEPS = {'A','B','C','D','E','F'};

    public static void main(String[] args) {
        setCoordinates();
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<count; i++) {
            sb.append(calculateDistance(sc.nextLine()));
            if (i<count-1) {
                sb.append(" ");
            }
        }
        sc.close();
        printResult(sb);
    }

    private static double calculateDistance(String s) {
        char[] path = s.toCharArray();
        double x = 0, y = 0;
        for (char c : path) {
            for (int j=0; j<STEPS.length; j++) {
                if (c == STEPS[j]) {
                    x += xC[j];
                    y += yC[j];
                    break;
                }
            }
        }
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    private static void setCoordinates() {
        xC = new double[STEPS.length];
        yC = new double[STEPS.length];

        double angle = 0, aStep = 60*Math.PI/180;

        for (int i=0; i<STEPS.length; i++) {
            xC[i] = Math.cos(angle);
            yC[i] = Math.sin(angle);
            angle += aStep;
        }
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
