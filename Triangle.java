import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 14.08.2016.
 */
public class Triangle {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(checkIsTrianglePossible(new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()}));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static int checkIsTrianglePossible(int[] array) {
        int tmp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return (array[2] > array[1] + array[0]) ? 0 : 1;
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
