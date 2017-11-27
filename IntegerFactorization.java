
/**
 * Created by @Serhii Sydorenko on 06.10.2016.
 *
 *
 * To have more practice with conditional statements we are going to write a program which uses complex condition.
 * I.e. one if ... else statement could be (and should be) nested inside other to solve this problem.

 Several triplets of numbers are given to you. Your task is to select minimum among each of triplets.

 Input data will contain in the first line the number of triplets to follow.
 Next lines will contain one triplet each.
 Answer should contain selected minimums of triplets, separated by spaces.

 Example:

 data:
 3
 7 3 5
 15 20 40
 300 550 137

 answer:
 3 15 137
 */
public class IntegerFactorization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        double inputData []= new double[num];
        for (int i=0;i<num; i++){
            inputData[i]=Double.parseDouble(sc.nextLine());
        }
        sc.close();

        String result="";
        for (int i=0;i<num;i++){
            result+=getSimpleNums(inputData[i])+" ";
        }
        System.out.println(result);
    }
    private static String getSimpleNums(double i){
        String tempResult="";
        int temp=2;
        while (true){
            if (i%temp==0){
                tempResult+=temp;
                i=i/temp;
                if (i==1){
                    break;
                } else {
                    tempResult+="*";
                }
            } else temp++;
        }

        return tempResult;
    }
}
