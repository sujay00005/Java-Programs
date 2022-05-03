package Searching;

import java.util.Scanner;

public class MaximumSideSquareSideMatrix {
    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);
        // System.out.println("Enter the value of M & N of an MxN matrix");
        // int m = input.nextInt();
        // int n = input.nextInt();

        // System.out.println("Enter the sorted array elements");
        // int[][] a = new int[m][n];
        // for (int i = 0; i < m; i++) {
        // System.out.println("Enter the elements of " + (i + 1) + "th row");
        // for (int j = 0; j < n; j++)
        // a[i][j] = input.nextInt();
        // }
        // System.out.println("Enter the number of test cases");
        // int t = input.nextInt();
        // System.out.println("Enter the threshold for each test cases");
        // int[] threshold = new int[t];
        // for (int i = 0; i < t; i++) {
        // threshold[i] = input.nextInt();
        // }

        int a[][] = { { 1, 1, 3, 2, 4, 3, 2 },{ 1, 1, 3, 2, 4, 3, 2 },{ 1, 1, 3, 2, 4, 3, 2 } };
        int threshold[] = {4};

        for (int i = 0; i < threshold.length; i++) {
            System.out.println(maxixmumSideSquare(a, threshold[i]));
        }
        // input.close();
    }

    public static int maxixmumSideSquare(int[][] a, int threshold) {
        int height = a.length;
        int width = a[0].length;
        int h;
        if (height > width)
            h = width;
        else
            h = height;
        int l = 1, m;

        while (l <= h) {
            m = (l + h) / 2;

            boolean r = greedy(a, m, threshold);
            if (!r)
                h = m - 1;
            else {
                boolean r1 = greedy(a, m + 1, threshold);
                if (!r1)
                    return m;
                else
                    l = m + 1;
            }
        }

        return 0;
    }

    public static boolean greedy(int[][] a, int side, int threshold) {
        // going top to bottom
        for (int i = 0; i < a.length - 1 - side; i++) {
            // for left to right
            for (int j = 0; j < a[0].length; j++) {
                int sum = 0;

                // left to right(top)
                for (int k = j; k < side + j; k++)
                    sum = sum + a[i][k];
                if (sum > threshold)
                    return false;
                sum = 0;

                // left to right(bottom)
                for (int k = j; k < side + j; k++)
                    sum = sum + a[i + side][k];
                if (sum > threshold)
                    return false;
                sum = 0;

                // top to bottom(left)
                for (int k = j; k < side + j; k++)
                    sum = sum + a[k][i];
                if (sum > threshold)
                    return false;
                sum = 0;

                for (int k = j; k < side + j; k++)
                    sum = sum + a[k][i + side];
                if (sum > threshold)
                    return false;
                sum = 0;

            }
        }
        return true;
    }
}