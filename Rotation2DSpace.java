import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 09.11.2016.
 *
 * Let's practice the geometry programming of rotations. Such functionality is quite popular in graphic editors,
 * but it is not the only use.

 For example here is the widget Sphere Tag Cloud which can be used in creating funny design of the web-page.
 Dragging the mouse over the cloud you should see it scrolling like a globe. The effect is achieved by performing
 just two rotations around two axes (for each of floating element).

 We'll start with something simpler. Suggest we have a planar map with points on it. For example it could be the
 picture of a sky with stars shining.

 The task is to perform rotation of the map by the given angle. Round the resulting coordinates to nearest integer.

 To check the result please output the names of stars sorted by Y coordinate and then by X (if the Ys are equal).

 Input data contain the number of stars N and the rotation angle A (counterclockwise, from 0 to 360 degrees).
 Next lines will contain data about one star each in form Name X Y. Coordnates would be integer, not exceeding 1000
 in absolute value.
 Answer should give the names of stars sorted by Y and then by X after rotation (and rounding).

 Note: sorting should be performed in ascending order, i.e. from smallest values to largest.

 Example:

 input data:
 4 45
 Deneb -10 10
 Algol 10 10
 Sirius -10 -10
 Mira 10 -10

 answer:
 Sirius Deneb Mira Algol
 You may see schematic diagram of such rotation on the picture above. Here Sirius is green, Deneb is red, Mira is
 yellow and Algol is blue.
 */
public class Rotation2DSpace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstInput = sc.nextLine();
        String temp[] = firstInput.split(" ");
        int num = Integer.parseInt(temp[0]);
        int rotate = Integer.parseInt(temp[1]);
        String inputData[] = new String[num];
        for (int i=0; i<num; i++){
            inputData[i] = sc.nextLine();
        }
        sc.close();

        String finalResult[] = new String [num];
        String tempResult [][] = new String[num][3];
        final double COF = Math.PI/180;
        for (int i=0; i<num; i++){
            String tempString[] = inputData[i].split(" ");
            String name = tempString[0];
            double x = Integer.parseInt(tempString[1]);
            double y = Integer.parseInt(tempString[2]);
            double rad = Math.sqrt(x*x+y*y);
            double angle = rotate*COF+Math.atan(y/x);
            double newX = rad*Math.cos(angle);
            double newY = rad*Math.sin(angle);
            tempResult[i][0] = name;
            tempResult[i][1] = ""+newX;
            tempResult[i][2] = ""+newY;
            System.out.println("Radius="+rad);
            System.out.println(angle);
            System.out.println(name);
            System.out.println(newX);
            System.out.println(newY);
        }

        for (int i=0; i<num; i++){
            String minName = tempResult[i][0];
            double minX = Double.parseDouble(tempResult[i][1]);
            double minY = Double.parseDouble(tempResult[i][2]);
            int count=0;
            for (int j=0; j<num; j++){
                String tempName = tempResult[j][0];
                double tempX = Double.parseDouble(tempResult[j][1]);
                double tempY = Double.parseDouble(tempResult[j][2]);
                if (tempY<minY){
                    minX = tempX;
                    minY = tempY;
                    minName = tempName;
                    count = j;
                } else {
                    if (tempY==minY){
                        if (tempX<minX){
                            minX = tempX;
                            minY = tempY;
                            minName = tempName;
                            count = j;
                        }
                    }
                }
            }
            finalResult[i] = minName;
            tempResult[count][1] = ""+10000+i;
            tempResult[count][2] = ""+10000+i;
        }
        for (int i=0; i<num; i++){
            System.out.print(finalResult[i]+" ");
        }
    }
}
