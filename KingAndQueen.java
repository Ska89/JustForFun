import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 13.09.2016.
 *
 * Programming of game playing algorithms, like Chess, have two principal tasks:

 assessing position, at least by checking which pieces could be taken;
 constructing a kind of minimax algorithm to select a move leading to position with best value.
 Let us start by solving a simple problem:

 There is a chessboard with 8 x 8 squares. There are the White King and Black Queen on it. Check whether the Queen
 could take the King.

 Remember - Queen could move to any distance vertically, horizontally or along any of two diagonals.

 8  - Q - - - - - -     - - - - - - - -
 7  - - - - Q - - -     - - - - - - Q -
 6  - - - - - - - -     - - - - - - - -
 5  - - - - - - - -     - - - Q - - - -
 4  - K - - - - Q -     - - Q - - - - -
 3  - - - - - - - -     - - - - - - - -
 2  - - - Q - - - -     - - - - - K - -
 1  - - - - - - - -     - Q - - - - - -
 a b c d e f g h     a b c d e f g h
 See these two examples, with schematically drawn boards. On both the King is shown with letter K while marks Q shows
 variants of placing the Queen.

 on the left scheme the King could be "eaten" by any of the four Queens;
 on the right scheme the King is in safe position - none of the four Queens can move to take him.
 Notice how the squares of the board are addressed. Columns (called files) are marked with latin letters from a to h,
 while rows (called ranks) are marked with digits from 1 to 8. So the King on the left diagram sits on the b4 square
 - and on the right diagram on the f2. We shall use this notation.

 Input data contain the number of test-cases in the first line.
 Next lines describe placement of the King and Queen for each testcase, by specifying their squares (King's first).
 Answer should give only letter Y or N for each of test-cases, meaning that King could be taken or not respectively.
 Separate letters with spaces.

 Example:

 input data:
 8
 b4 b8
 b4 e7
 b4 d2
 b4 g4
 f2 b1
 f2 c4
 f2 d5
 f2 g7

 answer:
 Y Y Y Y N N N N
 In this example the positions are taken from both of diagrams above - cases 1..4 from the left diagram and others
 from the right.


 */
public class KingAndQueen {
    public static void main (String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(checkForKingInDanger(sc.next(), sc.next()) ? "Y" : "N");
            if (i < count-1) {
                sb.append(" ");
                sc.nextLine();
            }
        }
        sc.close();
        printResult(sb);
    }

    private static boolean checkForKingInDanger(String k, String q) {
        int kingL = k.charAt(0);
        int kingD = k.charAt(1);
        int queenL = q.charAt(0);
        int queenD = q.charAt(1);

        return Math.abs(kingL - queenL) == Math.abs(kingD - queenD) || kingL == queenL || kingD == queenD;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
