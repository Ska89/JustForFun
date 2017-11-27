import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 15.09.2016.
 *
 * Prolific trader Paul Penniless wants to be millionaire. He is trying to buy or sell shares and make profit on the
 * changing prices. I.e. if he is lucky to buy 200 shares for 20 dounds apiece and sell in a week for 23, he gains 600
 * dounds in just few days.

 Paul read an article on Standard Deviation and has the new idea now. He at once realized that the main problem is that
 the broker (the company who provides service for playing at market) takes comission of 1% for each deal. So regarding
 example above Paul loses 40 dounds when buying shares and 46 more when selling them back. So the real profit is not 600
 but only 600 - 40 - 46 = 514 dounds.

 It is obvious for him now, that he should prefer operations with shares which are more volatile - i.e. the price of
 which changes in wider range, so that his profit from changing price is more significant when compared to broker's
 comission.

 For example, if initial price of shares was 50 (rather than 20) and it had grown to 52 when Paul sold them, his profit
 for 200 shares would be only 400 dounds. However, comission would be 100 dounds when buying and 104 when selling, so
 his real gain is only 96 dounds - more than half money was taken by broker!

 Paul decided that he will choose whether to deal with shares of some kind or not depending on the following rule:
 standard deviation of prices for these shares over the last fortnight should be at least four times greater than
 broker's comission (which is 1%), i.e. for share with mean price 50 comission is 0.5 and standard deviation should
 be equal or greater than 2.

 For example if the price was 99 dounds for 7 days and 101 for other 7 days, then the average price is 100, and broker
 comission (per share) is 1 dound. Standard deviation would be 1 dound also, so these shares do not deserve being bought
 or sold.

 Input data will contain number of stocks (share types or names) for which calculations should be done.
 Next lines contain descriptions of stock - the stock name (four latin letters) and then 14 values - prices for each
 day over last fortnight.
 Answer should contain names of stocks which are volatile enough by Paul's criteria (in the same order as they were
 given in the input).

 Example:

 input data:
 2
 JOOG 99 99 99 99 99 99 99 101 101 101 101 101 101 101
 GOLD 95 105 95 105 95 105 95 105 95 105 95 105 95 105

 answer:
 GOLD

 */
public class SharePriceVolatility {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            String s = findVolatileEnough(sc.nextLine());
            if (s != null) {
                sb.append(s);
                if (i < count - 1) sb.append(" ");
            }
        }
        sc.close();
        printResult(sb);
    }

    private static String findVolatileEnough(String s) {
        StringBuilder sb = new StringBuilder(s);
        int index = sb.indexOf(" ");
        String name = sb.substring(0, index);
        sb.delete(0, index + 1);

        int[] values = new int[14];
        for (int i = 0; i < 14; i++) {
            if (i < 13) {
                index = sb.indexOf(" ");
                values[i] = Integer.parseInt(sb.substring(0, index));
                sb.delete(0, index + 1);
            } else values[i] = Integer.parseInt(sb.toString());
        }

        int vSum = 0, dSum = 0;
        for (int v : values) vSum += v;
        double m = vSum / 14;

        for (int i = 0; i < 14; i++)
            dSum += (int) Math.pow((m - values[i]), 2);
        double d = Math.sqrt(dSum / 14);

        return d >= (4 * m / 100) ? name : null;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
