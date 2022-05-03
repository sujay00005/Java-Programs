package Searching;

import java.util.Scanner;

public class KthSmallestInMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of N of an NxN matrix");
        int n = input.nextInt();

        System.out.println("Enter the sorted array elements");
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the elements of " + (i + 1) + "th row");
            for (int j = 0; j < n; j++)
                a[i][j] = input.nextInt();
        }
        System.out.println("Enter the value of K");
        int k = input.nextInt();
        input.close();

        System.out.println(KthSmallInMatrix(a, k));
    }

    public static int KthSmallInMatrix(int[][] a, int k) {
        int n = a[0].length - 1;
        int l = Integer.MAX_VALUE, h = Integer.MIN_VALUE;
        for (int i = 0; i < a[0].length; i++) {
            if (l > a[i][0])
                l = a[i][0];
            if (h < a[i][n])
                h = a[i][n];
        }
        int m;
        while (l <= h) {
            m = (l + h) / 2;
            int count = count(a, m);
            if (count < k)
                l = m + 1;
            else {
                count = count(a, m - 1);
                if (count < k)
                    return m;
                else
                    h = m - 1;
            }
        }
        return -1;
    }

    // no.s smaller than m
    public static int count(int[][] a, int k) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] <= k)
                    count++;
            }

            // int l = 0, h = a.length - 1;
            // int m;
            // while (l <= h) {
            // m = (l + h) / 2;
            // if (a[i][m] < k)
            // l = m + 1;
            // else {
            // if (m > 0 && a[i][m - 1] < k) {
            // count += m;
            // break;
            // } else
            // h = m - 1;

            // }
            // }
            // System.out.println(k + "* " + count);
        }
        // System.out.println(k + "count " + count);
        return count;
    }
}
