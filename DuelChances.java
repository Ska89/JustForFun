import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 14.09.2016.
 *
 * Two friends, Alan and Bob are engaged in a deathly duel. They agreed to stand in front of each other and shoot until
 * one of them is mortally wounded.

 Since they have only one pistol, they will shoot in turns. Casting lots determined that Alan is first to fire.

 Before duelling they want to get life insurance. Insurance manager then needs to determine what are their chances to
 die, to calculate proper insurance cost.

 You are to help the manager in his calculations. You will be given the probability for both duellers to hit and hurt
 opponent critically with a single shot - and you asked to write a program which will tell Alan's chances to win
 (then Bob's chances to win could be calculated by manager himself as Alan's chances to die).

 Input data will contain the number of test-cases in first line.
 Next lines will contain two numbers pA and pB each - the chance to kill opponent with a shot for Alan and Bob
 respectively, expressed in percents (so the values would be integer).
 Answer should contain the chance for Alan to win (and for Bob to die) in percents, rounded to nearest integer.
 Separate several answers with spaces.

 Example:

 input data:
 2
 30 50
 20 15

 answer:
 46 63
 */
public class DuelChances {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(calculateChance(sc.nextInt(), sc.nextInt()));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static int calculateChance(int a, int b) {
        double pA = (double) a / 100, pB = (double) b / 100;
        double p = pA / (1 - (1 - pA) * (1 - pB));
        return doubleToPercents(p);
    }

    private static int doubleToPercents(double value) {
        int factor = (int) Math.pow(10, 2);
        value = value * factor;
        return (int) Math.round(value);
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
