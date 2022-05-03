package Searching;

import java.util.Scanner;

public class SearchingIn2DMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of m and n of 2D array");
        int m = input.nextInt();
        int n = input.nextInt();

        System.out.println("Enter the sorted array elements");
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.out.println("Enter the elements of " + (i + 1) + "th row");
            for (int j = 0; j < n; j++)
                a[i][j] = input.nextInt();
        }

        System.out.println("Enter the number of test cases present");
        int numberOfTests = input.nextInt();

        int[] testKeys = new int[numberOfTests];
        for (int i = 0; i < numberOfTests; i++) {
            testKeys[i] = input.nextInt();
        }
        input.close();

        for (int i = 0; i < numberOfTests; i++) {
            System.out.println(SearchIn2D(a, testKeys[i]));
        }
    }

    public static boolean SearchIn2D(int[][] a, int key) {
        int l = 0;
        int rowLength = a[0].length - 1;
        int h = rowLength;
        int m;
        for (int i = 0; i < a.length; i++) {
            if (key < a[i][0] || key > a[i][rowLength])
                continue;
            else {
                while (l <= h) {
                    m = (l + h) / 2;
                    if (key == a[i][m])
                        return true;
                    else if (key < a[i][m])
                        h = m - 1;
                    else
                        l = m + 1;
                }
            }
        }
        return false;
    }
}
