import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 03.09.2016.
 *
 * We are given strings containing brackets of 4 types - round (), square [], curly {} and angle <> ones. The goal is
 * to check, whether brackets are in correct sequence. I.e. any opening bracket should have closing bracket of the same
 * type somewhere further by the string, and bracket pairs should not overlap, though they could be nested:

 (a+[b*c] - {d/3})  - here square and curly brackets are nested in the round ones

 (a+[b*c) - 17]     - here square brackets overlap with round ones which does not make sense
 Input data will contain number of testcases in the first line.
 Then specified number of lines will follow each containing a test-case in form of a character sequence.
 Answer should contain 1 (if bracket order is correct) or 0 (if incorrect) for each of test-cases, separated by spaces.

 Example:

 input data:
 4
 (a+[b*c]-{d/3})
 (a + [b * c) - 17]
 (((a * x) + [b] * y) + c
 auf(zlo)men [gy<psy>] four{s}

 answer:
 1 0 0 1
 Note that all non-bracket characters could be safely ignored!



 */
public class MathcingBrackets {
    public static int checkIn(char ch) {
        int result;
        switch (ch) {
            case '(':
                result = 1;
                break;
            case '[':
                result = 2;
                break;
            case '{':
                result = 3;
                break;
            case '<':
                result = 4;
                break;
            default:
                result = -1;
                break;
        }
        return result;
    }

    public static int checkOut(char ch) {
        int result;
        switch (ch) {
            case ')':
                result = 1;
                break;
            case ']':
                result = 2;
                break;
            case '}':
                result = 3;
                break;
            case '>':
                result = 4;
                break;
            default:
                result = -1;
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();

        String [] intputData = new String[num];
        for (int i=0; i<intputData.length; i++){
            intputData[i]=sc.nextLine();
        }
        sc.close();

        String result = "";

        for (int i=0; i<intputData.length; i++){
            boolean flag = true;
            char [] workData = intputData[i].toCharArray();
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int j=0; j<workData.length; j++){
                int temp = checkIn(workData[j]);
                if (temp>0){
                    stack.addLast(temp);
                } else {
                    temp=checkOut(workData[j]);
                    if (temp>0){
                        if (stack.isEmpty() || stack.pollLast()!=temp){
                            flag=false;
                            break;
                        }
                    }
                }
            }
            if (flag && stack.isEmpty()){
                result+="1 ";
            }else {
                result+="0 ";
            }
        }

        System.out.println(result);
    }
}
