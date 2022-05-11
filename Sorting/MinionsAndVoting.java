package Sorting;

import java.util.Scanner;

public class MinionsAndVoting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of points present ");
        int n = input.nextInt();

        int a[] = new int[n];

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        // input.close();
    }

    public static void prefixSum(int[] a) {
        for (int i = 1; i < a.length; i++) {
            a[i] = a[i] + a[i - 1];
        }
    }

    public static int search(int a[], int i, int l, int h) { // i is current index
        int m;

        while (l <= h) {
            m = (l + h) / 2;

            if (a[m] - a[i] < a[i] - a[i - 1])
                l = m + 1;
            else {
                if (a[m] - a[i] == a[i] - a[i - 1])
                    return m;
                else
                    h = m - 1;
            }
        }
        return -1;
    }
}
