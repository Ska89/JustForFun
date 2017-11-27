import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 08.09.2016.
 *
 *
 * Being able to calculate area of triangle is quite important since many more complex tasks are often easily reduced
 * to this (and we will use it too later).

 One of the oldest known methods is Heron's Formula which takes as inputs the lengths of the triangle's sides.

 In this problem you however is to write a program which uses X and Y coordinates of the triangle's vertices instead.
 So you can use either this formula somehow or find another one.

 Input data will contain the number of triangles to process.
 Next lines will contain 6 values each, in order X1 Y1 X2 Y2 X3 Y3, describing three vertices of a triangle.
 Answer should give areas of triangles separated by space (precision about 1e-7 is expected).

 Example:

 data:
 3
 1 3 9 5 6 0
 1 0 0 1 10000 10000
 7886 5954 9953 2425 6250 2108

 answer:
 17 9999.5 6861563


 */
public class TriangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();

        String inputData [] = new String[num];
        for (int i=0; i<num; i++){
            inputData[i]=sc.nextLine();
        }
        sc.close();
        String result = "";

        for (int i=0; i<num; i++){
            String [] temp = inputData[i].split(" ");
            double a = Math.sqrt(Math.pow((Integer.parseInt(temp[0])-Integer.parseInt(temp[2])),2)+Math.pow((Integer.parseInt(temp[1])-Integer.parseInt(temp[3])),2));
            double b = Math.sqrt(Math.pow((Integer.parseInt(temp[2])-Integer.parseInt(temp[4])),2)+Math.pow((Integer.parseInt(temp[3])-Integer.parseInt(temp[5])),2));
            double c = Math.sqrt(Math.pow((Integer.parseInt(temp[0])-Integer.parseInt(temp[4])),2)+Math.pow((Integer.parseInt(temp[1])-Integer.parseInt(temp[5])),2));
            double p = (a+b+c)/2;
            result+=Math.sqrt(p*(p-a)*(p-b)*(p-c))+" ";
        }
        System.out.println(result);
    }
}
