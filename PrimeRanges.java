import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 12.09.2016.
 *
 * If you already solved Prime Numbers Generation - here is an inverse version of it.

 Given several pairs of primes (like a, b) you are to tell for each of them the total quantity of primes in the
 range limited by these values (inclusive), i.e. such p-s that:

 isPrime(p) = true

 and

 a <= p <= b
 Input data: will contain the amount of pairs in the first line.
 Next lines will contain one pair of primes each, the first value is always less than the second. All values will be
 less than 3000000.
 Answer should contain the quantity of primes in the ranges specified by these pairs.

 Example:

 input data:
 3
 5 19
 11 29
 2 23

 answer:
 6 6 9
 Hint: you may start with generation of the array (or list) of primes in ascending order. However you will need to use
 some effective method for searching values in this list, otherwise your program would work significantly slower than
 it should.


 */
public class PrimeRanges {
    private static int[] PRIMES;

    public static void main(String[] args) throws Exception {
        PRIMES = findPrimeNumbers(3000000);
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(calculateQuantity(sc.nextInt(), sc.nextInt()));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static int calculateQuantity(int a, int b) {
        return binarySearch(b) - binarySearch(a) + 1;
    }

    private static int binarySearch(int n) {
        int l = 0;
        int h = PRIMES.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (n < PRIMES[mid]) h = mid - 1;
            else if (n > PRIMES[mid]) l = mid + 1;
            else return mid;
        }
        return -1;
    }

    private static int[] findPrimeNumbers(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        int sqrt = (int) Math.sqrt(limit);

        for (int x = 1; x <= sqrt; x++) {
            for (int y = 1; y <= sqrt; y++) {

                int x2 = x * x, y2 = y * y, n = 4 * x2 + y2;
                if (n <= limit && (n % 12 == 1 || n % 12 == 5)) isPrime[n] ^= true;

                n -= x2;
                if (n <= limit && n % 12 == 7) isPrime[n] ^= true;

                n -= 2 * y2;
                if (x > y && n <= limit && n % 12 == 11) isPrime[n] ^= true;
            }
        }

        for (int n = 5; n <= sqrt; n += 2) {
            if (isPrime[n]) {
                int s = n * n;
                for (int k = s; k <= limit; k += s)
                    isPrime[k] = false;
            }
        }

        isPrime[2] = true;
        isPrime[3] = true;

        int count = 0;
        for (boolean b : isPrime) if (b) count++;

        int[] primes = new int[count];
        count = 0;
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primes[count] = i;
                count++;
            }
        }
        return primes;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
