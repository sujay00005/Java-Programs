package Sorting;

import java.util.Scanner;

public class Manhattan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of points present");
        int n = input.nextInt();

        System.out.println("Enter the 'x' and 'y' co-ordinate for each point");
        int[][] points = new int[n][2];

        for (int i = 0; i < n; i++) {
            points[i][0] = input.nextInt();
            points[i][1] = input.nextInt();
        }
        input.close();

        sort(points);
    }

    public static void sort(int[][] a) {
        int sum = 0;

        int c = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                sum += manhattanDistance(a[i][0], a[i][1], a[j][0], a[j][1]);
            }
        }
        System.out.println(sum);

    }

    public static int manhattanDistance(int x1, int y1, int x2, int y2) {
        return (int) (Math.abs(x1 - x2) + Math.abs(y1 - y2));
    }
}
