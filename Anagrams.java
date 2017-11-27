import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 06.10.2016.
 *
 * In many natural languages we can find some pairs of words which could be transformed to each other by changing the
 * order of letters. I.e. they consist of the same set of letters, for example:
 * cat - act take - teak ate - eat - tea
 * Such words are called anagrams and as we see in the third example sometimes there are more than two words.
 * Your task is to find out the amount of anagrams for given word by the dictionary.
 * Click this link with right mouse button and select "Save As" to download dictionary file
 * Dictionary file contains a list of english words, one per line. It was taken from Ubuntu linux distribution and
 * stripped of words containing capital letters, apostrophes and non-english letters.
 * Input data will contain the number of test-cases in the first line.
 * Next lines will contain a single word each.
 * Answer should contain the number of anagrams for each word (not including the word itself).
 * Example:
 * input data:
 * 3
 * bat
 * coal
 * lots
 *
 * answer:
 * 1 1 2


 */
public class Anagrams {
    private static String[] wordsArray;

    public static void main(String[] args) {
        fillWordsArray();
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(calculateAnagrams(sc.nextLine()));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static int calculateAnagrams(String s) {
        int length = s.length(), checkSum = 0, countMatches = 0;
        char[] cInput = sortArray(s.toCharArray());
        for (char c : cInput) checkSum += c;

        for (String word : wordsArray) {
            if (word.length() == length) {
                int wordCheckSum = 0;
                char[] cWord = word.toCharArray();
                for (char c : cWord) wordCheckSum += c;
                if (wordCheckSum == checkSum && !s.equals(word)) {
                    cWord = sortArray(cWord);
                    boolean match = true;
                    for (int i = 0; i < cInput.length; i++) {
                        if (cInput[i] != cWord[i]) {
                            match = false;
                            break;
                        }
                    }
                    if (match) countMatches++;
                }
            }
        }
        return countMatches;
    }

    private static char[] sortArray(char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            char max = 0;
            int maxPos = array.length - 1;
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > max) {
                    max = array[j];
                    maxPos = j;
                }
            }
            if (maxPos != array.length - i - 1) {
                array[maxPos] = array[array.length - i - 1];
                array[array.length - i - 1] = max;
            }
        }
        return array;
    }

    private static void fillWordsArray() {
        try {
            File file = new File("C:\\Users\\Ihor\\IdeaProjects\\CodeAbbey\\words.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder dictionary = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                dictionary.append(line);
                dictionary.append("\n");
            }
            fileReader.close();
            wordsArray = dictionary.toString().split("\\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
