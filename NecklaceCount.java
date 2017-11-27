import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 22.11.2016.
 *
 *
 * It is a classical puzzle. Martin Gardner mentions that it is found at "one of puzzle collections by Henry E Dudeney",
 * though I failed to trace the original.

 Little Alice has a lot of color beads. She can pick several of them and string them into necklace.

 She found that with only 2 beads of only 2 colors (say, red and green) three different necklaces could be created -
 for example:

 red-red
 red-green
 green-green
 With 3 beads of 2 colors it is possible to make 4 necklaces. The image above shows 6 variants made of 4 two-color beads.

 You see, since the necklace have ends of the string tied together, there are far less variants than for linear strings
 of beads - i.e. while strings like

 red-green-red
 red-red-green
 are different before their ends are tied, they nevertheless produce the same necklace.

 However we differ necklaces which are "mirror" of each other (since it is not possible to convert one into another
 simply by rotating it around the neck). For example

 red-red-green-red-green-green
 is not the same as

 red-red-green-green-red-green
 If we do not distinguish mirrored necklaces, they are usually called bracelets. However this does not change problem
 significantly so we do not include this minor implication. (so for example with 6 beads of 2 colors we can make 14
 necklaces but only 13 bracelets).

 Input data contains the number of testcases in the first line.
 Next lines contain a pair of values each - the number of colors B - and the amount of beads to form necklace N.
 Answer should contain the number of different necklaces which could be made in each case.

 Example:

 input data:
 3
 2 6
 9 4
 12 1

 answer:
 14 1665 12
 Limits: B <= 12 and N (depending on it) would be such that the result will not exceed few millions.
 */
public class NecklaceCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String inputData[] = new String[num];
        for (int i = 0; i < num; i++) {
            inputData[i] = sc.nextLine();
        }
        sc.close();
        System.out.println(getResult(inputData));
    }
    private static String getResult(String inputData[]){
        String result = "";
        for (int i=0; i<inputData.length; i++){
            String temp[] = inputData[i].split(" ");
            int k = Integer.parseInt(temp[0]);
            int n = Integer.parseInt(temp[1]);
            int tempResultDown = n;
            int tempResultUp = 0;

            for (int j = 1; j<=n; j++){
                tempResultUp+=Math.pow(k,nod(j,n));
            }
            result+=tempResultUp/tempResultDown+" ";
        }
        return result;
    }
    private static int nod(int a, int b){
        if (b==0) return a;
        int x = a%b;
        return nod(b,x);
    }
}
