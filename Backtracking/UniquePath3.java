package Backtracking;

import java.util.Scanner;

public class UniquePath3 {
    public static boolean[][] isVisited = new boolean[3][3];
    public static int m;
    public static int n;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of no. of rows and column present in the matrix");
        m = input.nextInt();
        n = input.nextInt();

        int a[][] = new int[m][n];
        System.out.println("Enter the matrix elements");
        for (int i = 0; i < m; i++) {
            System.out.println("Enter the matrix elements of " + (i + 1) + " row");
            for (int j = 0; j < n; j++) {
                a[i][j] = input.nextInt();

            }
        }

        System.out.println(countPermutation(a, 0, 0));
    }

    public static int countPermutation(int[][] a, int i, int j) {
        if (i == m && j == n)
            return 1;

        isVisited[i][j] = true;
        int sum = 0;
        if (isSafe(i, j + 1, a) && isVisited[i][j + 1])
            sum += countPermutation(a, i, j + 1);
        if (isSafe(i, j - 1, a) && isVisited[i][j - 1])
            sum += countPermutation(a, i, j - 1);
        if (isSafe(i + 1, j, a) && isVisited[i + 1][j])
            sum += countPermutation(a, i + 1, j);
        if (isSafe(i - 1, j, a) && isVisited[i - 1][j])
            sum += countPermutation(a, i - 1, j);
        isVisited[i][j] = false;
        return sum;
    }

    public static boolean isSafe(int i, int j, int[][] a) {
        if (i < m && j < n)
            if (a[i][j] == -1)
                return false;
        return true;
    }
}
