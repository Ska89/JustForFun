import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 08.09.2016.
 *
 * There is a game which is of special importance in the Computer Science because it though simple itself, could be
 * used for creating very cunning Artificial Intelligence algorithms to play against human (or each other) with
 * predicting the opponent's behavior.

 This ancient game is played between two participants who simultaneously cast one of three figures by their fingers -
 Rock, Paper or Scissors.

 If both cast the same figure, the round is considered a draw. Otherwise the following rules are applied:

 Rock beats Scissors (by blunting them)
 Scissors beat Paper (by cutting it)
 Paper beats Rock (by covering it)
 Often the game is played on the staircase. Player who wins the round advances one step. One who reaches the end of the
 staircase first is the winner.

 You will be given several records of the played games. You are to tell for each of them who of players won.

 Input data will contain the number of matches played in the first line.
 Then the matches description is written in separate lines.
 Each line contain several pairs of letters, like PR (first casts Paper, second casts Rock), or SS (both cast Scissors),
 separated with spaces.
 Answer should for each of matches specify whether first player wins (by value 1) or second (by value 2). There would
 be no draws.

 Example:

 input data:
 3
 SS PR
 PR RS PS PP SP
 PS RR PS RP

 answer:
 1 1 2
 */
public class RockPaperScissors {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(findTheWinner(sc.nextLine()));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static int findTheWinner(String s) {
        StringBuilder sb = new StringBuilder(s);
        int index, count1 = 0, count2 = 0;
        char c1, c2;
        while (sb.length() != 0) {
            index = sb.indexOf(" ");
            if (index == -1) {
                c1 = sb.charAt(0);
                c2 = sb.charAt(1);
                sb.delete(0, sb.length());
            } else {
                c1 = sb.charAt(0);
                c2 = sb.charAt(index - 1);
                sb.delete(0, index + 1);
            }
            if (c1 != c2) {
                if (c1 == 'S' && c2 == 'P') count1++;
                else if (c1 == 'P' && c2 == 'S') count2++;
                else if (c1 > c2) count2++;
                else count1++;
            }
        }
        return count1 > count2 ? 1 : 2;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
