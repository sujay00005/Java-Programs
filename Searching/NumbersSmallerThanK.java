package Searching;

import java.util.Scanner;

public class NumbersSmallerThanK {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements present in the array");
        int n = input.nextInt();

        System.out.println("Enter the sorted array elements");
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the elements of " + (i + 1) + "th row");
            for (int j = 0; j < n; j++)
                a[i][j] = input.nextInt();
        }
        System.out.println("Enter the value of k to find number of elements smaller than k");
        int k = input.nextInt();
        // input.close();

        System.out.println(NumberSmaller(a, k));
    }

    public static int NumberSmaller(int[][] a, int k) {
        int l = 0, h = a.length - 1, m;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            while (l <= h) {
                m = (l + h) / 2;
                if (a[i][m] < k)
                    l = m + 1;
                else {
                    if (m > 0 && a[i][m - 1] < k) {
                        count += m;
                        break;
                    } else
                        h = m - 1;
                }
            }
        }
        return count;

    }

}
