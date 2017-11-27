import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 13.09.2016.
 *
 * Joel wants to buy a boat which costs $10000. However, he currently has only $1000. One of the ways to increase
 * money is to put them into bank account and wait. For example, if account is incresed by 8% each year:

 year     money
 0       1000
 1       1080
 2       1166.4
 3       1259.71
 4       1360.48
 5       1469.31
 6       1586.85
 .....
 29       9316.82
 30      10062.16
 then Joel can grow his money in 30 years. Moreover, if account is increased not annually but monthly (with the same
 interest rate of 8% per year) then the sum will be collected in only 29 years! Quite funny :)

 In this task you need to help Joel to calculate how many years he need to wait depending on given starting amount
 of money S, required sum R and bank's interest rate P. At the end of each year account is increased and rounded down
 to whole cents (as in example above).

 Input data contain number of test-cases in the first line.
 Each of the following lines contain three numbers S, R and P.
 Answer should contain number of years to wait for each case, separated by spaces.

 Example:

 input data:
 2
 1000 10000 8
 50 100 25

 answer:
 30 4


 */
public class SavingCalculator {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(calculateCountOfYears(sc.nextInt(), sc.nextInt(), sc.nextInt()));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static int calculateCountOfYears(int s, int r, int p) {
        double per = (double) p / 100;
        int years = 0;
        double sum = s;
        do {
            sum += sum * per;
            years++;
        } while (sum < r);
        return years;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
