package Sorting;

import java.util.Scanner;

public class LengthUnsortedArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of points present ");
        int n = input.nextInt();

        int a[] = new int[n];

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        input.close();

        findIndex(a, n);
    }

    public static void findIndex(int[] a, int n) {
        int i = 0;

        while (i < n && a[i] <= a[i + 1]) {
            i++;
        }
        int startIndex = i;
        i = n - 1;
        while (i > 0 && a[i] >= a[i - 1]) {
            i--;
        }
        i = i + 1;
        System.out.println(startIndex + " * " + i);
    }
}
