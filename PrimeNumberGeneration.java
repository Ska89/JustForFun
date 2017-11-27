import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 15.08.2016.
 *
 *
 In this task we are going to implement the primes generator. Primes are positive integers which have no other
 divisors except 1 and itself. You may read more in wiki article. Most popular algorithms to practice are either Sieve
 of Eratosthene or Trial division. You are encouraged to google for them if you need more details.

 So let us create the array (or list) of prime numbers in ascending order, i.e.:

 [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, ...]
 And then print the primes corresponding to the indices given in the input data.

 Input data will contain the amount of primes to print in the first line.
 Next line will contain indices of array of primes for which values should be printed. They will be in range from 1
 to 200000.
 Answer should contain prime numbers corresponding the specified positions of the array.

 Note that for this task we start indexing an array from 1 rather than 0 (this may help you in checking your program
 with many lists of primes which could be found online).

 Example:

 input data:
 4
 7 1 199999 4

 answer:
 17 2 2750131 7
 Take care of implementing the algorithm efficiently - with proper approach all 200000 primes should be generated in
 about a second (somewhat slower with scripting languages like Python, or older computer).



 */
public class PrimeNumberGeneration {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int[] primeNumbers = findPrimeNumbers();
        for (int i = 0; i < count; i++) {
            sb.append(primeNumbers[sc.nextInt() - 1]);
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static int[] findPrimeNumbers() {
        int limit = 2750169;
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
                for (int k = s; k <= limit; k += s) isPrime[k] = false;
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
