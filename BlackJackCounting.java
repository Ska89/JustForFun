import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 08.09.2016.
 *
 *
 */
public class BlackJackCounting {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(countPoints(sc.nextLine().replaceAll("\\s", "").toCharArray()));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static String countPoints(char[] cards) {
        int points = 0, aceCount = 0;
        for (char c : cards) {
            switch (c) {
                case 'T':
                case 'J':
                case 'Q':
                case 'K':
                    points += 10;
                    break;
                case 'A':
                    points++;
                    aceCount++;
                    break;
                default:
                    points += Character.getNumericValue(c);
            }
        }
        if (aceCount > 0 && points + 10 <= 21) points += 10;
        return points > 21 ? "Bust" : String.valueOf(points);
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
