/**
 * Created by @Serhii Sydorenko on 07.08.2016.
 *
 *
 *
 You probably already solved the problem Minimum of Three - and it was not great puzzle for you? Since programmers
 should improve their logic (and not only skills in programming language), let us change the task to make it more tricky.

 You will be again given triplets of numbers, but now the middle of them should be chosen - i.e. not the largest and
 not the smallest one. Such number is called the Median (of the set, array etc).

 Be sure, this problem is not simply "another stupid exercise" - it is used as a part in powerful QuickSort algorithm,
 for example.

 Input data will contain in the first line the number of triplets to follow.
 Next lines will contain one triplet each.
 Answer should contain selected medians of triplets, separated by spaces.

 Example:

 data:
 3
 7 3 5
 15 20 40
 300 550 137

 answer:
 5 20 300
 Note: if your program will have a lot of if-else-if-else statements, then you are probably doing something wrong.
 Simple solution should have no more than three of them.


 */
public class MedianOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.nextLine();

        String inData[] = new String[x];

        for (int i = 0; i < x; i++) {
            inData[i] = sc.nextLine();
        }
        sc.close();

        String result = "";
        for (int i = 0; i < x; i++) {
            String in[] = inData[i].split(" ");
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);
            int c = Integer.parseInt(in[2]);
            if (a>c){
                if (a>b){
                    if (b>c){
                        result+=b+" ";
                    } else {
                        result+=c+" ";
                    }
                } else {
                    result+=a+" ";
                }
            } else {
                if (b>c){
                    result+=c+" ";
                } else{
                    if (a>b){
                        result+=a+" ";
                    } else {
                        result+=b+" ";
                    }
                }
            }
        }
        System.out.println(result);
    }
}
