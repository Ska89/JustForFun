import java.util.*;

/**
 * Created by @Serhii Sydorenko on 26.10.2016.
 *
 * The task Matching Words allows easy but ineffective solution because it works with very small input data.

 This problem is similar, but you will need to proceed almost one million words and choose a single, most frequent of
 them - it is very often and very important task - for example performed by search engines over web pages. You will need
 to use efficient algorithm, otherwise your program will work for hours and perhaps days.

 Since it is not practical to provide test-cases consisting of so many letters along with problem statement, you will
 generate the words yourself.

 Use algorithm from the task Funny Words Generator to create a list of exactly 900000 words, each 6 letters long.
 You should use exactly the same Linear Congruential Generator as random generator. The only input parameter would be
 the seed for your random number generator (LCG).

 Input data will contain a single value - the seed for random generator which you will use to generate list of words.
 Answer should contain a single word - one most frequently encountered in the list.

 Example:

 input data:
 99658

 answer:
 riguzi
 Test-cases are selected so that there would be only one most frequent word for each given seed.
 */
    public class MostFrequentWord {
    private static final char[] CONSONANTS = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'r', 's', 't', 'v', 'w', 'x', 'z'};
    private static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int seed = Integer.parseInt(sc.nextLine());
        sc.close();
        printResult(findMostFrequentWord(seed));
    }

    private static String findMostFrequentWord(int seed) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < 900000; i++) {
            int[] randoms = generateRandoms(seed, 6);
            seed = randoms[randoms.length - 1];
            String word = generateWord(randoms);
            boolean b = set.add(word);
            if (!b) {
                Integer count = map.get(word);
                map.put(word, (count == null) ? 2 : count + 1);
            }
        }

        int maxValue = Collections.max(map.values());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValue) return entry.getKey();
        }

        return null;
    }

    private static String generateWord(int[] randoms) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < randoms.length; i++)
            sb.append((i + 1) % 2 == 0 ? VOWELS[randoms[i] % 5] : CONSONANTS[randoms[i] % 19]);
        return sb.toString();
    }

    private static int[] generateRandoms(int x, int n) {
        int a = 445, c = 700001, m = 2097152, count = 0;
        int[] res = new int[n];
        while (count != n) {
            x = (a * x + c) % m;
            res[count] = x;
            count++;
        }
        return res;
    }

    private static void printResult(String res) {
        System.out.println(res);
    }
}
