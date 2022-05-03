package Searching;

import java.util.Scanner;

public class KthSmallestInMultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of test cases present");
        int t = input.nextInt();

        int m[] = new int[t];
        int n[] = new int[t];
        int k[] = new int[t];
        for (int i = 0; i < t; i++) {
            System.out.println("Enter the value of m n and k for " + (i + 1) + "th test case");
            m[i] = input.nextInt();
            n[i] = input.nextInt();
            k[i] = input.nextInt();
        }
        input.close();

        for (int i = 0; i < t; i++) {
            int[][] a = new int[m[i]][n[i]];
            for (int l = 1; l <= m[i]; l++) {
                for (int j = 1; j <= n[i]; j++) {
                    a[l - 1][j - 1] = l * j;
                }
            }
            System.out.println(KthSmallInMatrix(a, k[i]));
        }

    }

    public static int KthSmallInMatrix(int[][] a, int k) {
        int n = a[0].length - 1;
        int l = Integer.MAX_VALUE, h = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
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
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] <= k)
                    count++;
            }
        }
        // System.out.println(k + "count " + count);
        return count;
    }
}
