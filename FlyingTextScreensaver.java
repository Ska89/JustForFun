import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 17.10.2016.
 *
 * This useless program is sometimes proposed by school teachers: using extended console functions for positioning
 * cursor and printing text in any possible position on the screen, pupils are to create effect of the flying text
 * with the given string.

 Text should move diagonally with the constant speed (for example, 3 cells per second) and bounce from the borders.
 Bouncing means that when the string reaches last or first line, it changes the vertical direction - and when its end
 or start touches last or first column respectively - it changes the horizontal direction.

 Text:
 I can fly!
 Restart
 Flying Text screensaver on the alpha-numeric display
 Play with the demo above to get better idea of how it works. Or, perhaps, write such program using what means your
 programming language offer - and see it in action.

 Your task now is to track the path of the flying text.

 Input data will contain Width and Height of the imaginary screen and the Length of text string.
 Answer should dump pairs of coordinates X and Y of the beginning of the text for first 100 steps (spaces should be used
 to separate values in the pair and pairs themselves) - i.e. 202 integers in total (including coordinates of the
 starting position).

 Coordinate system of the screen usually has the (0, 0) in the left top corner.

 Example:

 input data:
 9 3 4

 answer:
 0 0 1 1 2 2 3 1 4 0 5 1 4 2 3 1 2 0 ... 4 0 3 1 2 2 1 1 0 0
 */
public class FlyingTextScreensaver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printResult(trackPathCoordinates(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        sc.close();
    }

    private static StringBuilder trackPathCoordinates(int w, int h, int l) {
        StringBuilder sb = new StringBuilder();
        int x = 0, y = 0, sX = 1, sY = 1;
        for (int i = 0; i <= 100; i++) {
            sb.append(x);
            sb.append(" ");
            sb.append(y);
            if (i < 100) sb.append(" ");
            if (x + sX < 0 || x + sX + l > w) sX *= -1;
            if (y + sY < 0 || y + sY >= h) sY *= -1;
            x += sX;
            y += sY;
        }
        return sb;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
