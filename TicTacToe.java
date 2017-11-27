import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 14.09.2016.
 *
 *
 * At this time we are not programming computer opponent for the game of Crosses and Noughts, but an important part for
 * such an algorith - the checking function, which can tell whether the game is ended and won by one or another side.

 The game is played on the square field 3 x 3. Let us suppose that the cells are numerated in the following way:

 1 | 2 | 3
 ---+---+---
 4 | 5 | 6
 ---+---+---
 7 | 8 | 9
 Two players put their marks (X for first and O for second) in turns into any of free cells remaining. One who completes
 the straight line of three marks (three X-s or three O-s) immediately wins. Lines could be filled either in rows or
 columns or one of two diagonals (8 lines possible in total). For example suppose the following moves were performed:

 X   O
 -------
 7
 5
 4
 1
 9
 2
 8
 Which leads to the following position:

 O | O |
 ---+---+---
 X | O |
 ---+---+---
 X | X | X
 with first player (Crosses) winning by completing the third row.

 Problem statement
 You will be given the sequence of moves (supposing the first move is always done by X) - by the numbers of cells where
 marks are placed - and your task is to determine, at which step the first line was completed (by any side).

 Input data contain the number of test-cases in the first line.
 Next lines have one test-case each - exactly 9 numbers, describing cells to which moves are performed in order.
 Answer should contain the number of the move at which game is won by one of players (starting from 1) or 0 if the game
 is drawn (no winner) after the last move.

 Example:

 input data:
 3
 7 5 4 1 9 2 8 3 6
 5 1 3 7 6 4 2 9 8
 5 1 2 8 6 4 7 3 9

 answer:
 7 6 0

 */
public class TicTacToe {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int[] array = new int[9];
            for (int j = 0; j < 9; j++)
                array[j] = sc.nextInt();
            sb.append(countStepsToWin(array));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static int countStepsToWin(int[] array) {
        int[] game = new int[9];
        for (int i = 0; i < 9; i++) {
            game[array[i] - 1] = (i + 1) % 2 == 0 ? 2 : 1;

            if (i > 6) {
                if (
                        game[0] == game[1] && game[0] == game[2] ||
                                game[3] == game[4] && game[3] == game[5] ||
                                game[6] == game[7] && game[6] == game[8] ||
                                game[0] == game[3] && game[0] == game[6] ||
                                game[1] == game[4] && game[1] == game[7] ||
                                game[2] == game[5] && game[2] == game[8] ||
                                game[0] == game[4] && game[0] == game[8] ||
                                game[2] == game[4] && game[2] == game[6])

                    return i + 1;
            } else if (i > 3) {
                if (
                        game[0] != 0 && game[0] == game[1] && game[0] == game[2] ||
                                game[3] != 0 && game[3] == game[4] && game[3] == game[5] ||
                                game[6] != 0 && game[6] == game[7] && game[6] == game[8] ||
                                game[0] != 0 && game[0] == game[3] && game[0] == game[6] ||
                                game[1] != 0 && game[1] == game[4] && game[1] == game[7] ||
                                game[2] != 0 && game[2] == game[5] && game[2] == game[8] ||
                                game[0] != 0 && game[0] == game[4] && game[0] == game[8] ||
                                game[2] != 0 && game[2] == game[4] && game[2] == game[6])

                    return i + 1;
            }
        }
        return 0;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
