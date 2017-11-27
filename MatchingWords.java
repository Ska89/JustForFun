import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by @Serhii Sydorenko on 08.09.2016.
 *
 * Ali-Baba found a secret cave with treasures, stored by The Forty Thieves. However, famous magical phrase Open
 * Sesame obviously does not work.

 Instead there is a long and strange text inscribed on the stone wall - and Ali-Baba guessed that one should find
 matching words in this inscription (i.e. ones which are encountered more than once) and pronounce them in alphabetical
 order.

 We are to help the poor craftsman to access the thieves' treasury. Let's write a program that sieves necessary words
 from the given text, and prints them in the proper order.

 Input data consist of about 300 words, each made of 3 Latin letters. The end is signaled by the word end.
 Answer should contain all the words which are encountered more than once in lexicographic order.

 Example:

 input data:
 nun lam mip tex bal pif sot bal bod tex end

 answer:
 bal tex
 Note: although for small amount of words one can write double nested loop to compare words, this approach is
 inefficient for large numbers of words - it is not suitable for one million words etc. Try to invent a better approach.


 */
public class MatchingWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputData = sc.nextLine();
        sc.close();
        System.out.println(getResult(inputData));
    }
    private static String getResult(String inputData){
        String workData[] = inputData.split(" ");
        TreeSet<String> temp = new TreeSet<>();
        TreeSet<String> tempResult = new TreeSet<>();

        for (int i=0; i<workData.length; i++){
            if (!temp.add(workData[i])){
                tempResult.add(workData[i]);
            }
        }
        String result="";
        for (String i:tempResult){
            result+=i+" ";
        }
        return result;
    }
}
