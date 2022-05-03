package Sorting;

import java.util.Scanner;

public class QuickSort {
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

        quickSort(a, 0, n - 1);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void quickSort(int[] a, int i, int j) {
        if (i < j) {
            int p = partition(a, i, j);
            quickSort(a, i, p - 1);
            quickSort(a, p + 1, j);
        }
    }

    public static int partition(int[] a, int i, int j) {
        // ith element is taken as pivot and other elements are sorted according to it
        int l = i + 1;
        int r = j;

        // runs till left pointer don't cross right pointer
        while (l <= r) {
            while (l <= j && a[l] <= a[i]) // l<=j maintains in case of descending order
                l++;
            while (r >= i && a[r] > a[i]) // r>=i maintains in case of ascending order
                r--;
            if (l < r)
                swap(a, l, r);
        }
        swap(a, i, r);
        return r;
    }

    public static void swap(int[] a, int i, int j) {
        System.out.println(a[i] + " " + a[j]);
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
