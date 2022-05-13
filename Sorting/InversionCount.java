package Sorting;

import java.util.Scanner;

public class InversionCount {
    public static int count = 0;

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

        mergeSort(a, 0, a.length - 1);
        System.out.println(count);
    }

    public static void mergeSort(int a[], int i, int j) {
        if (i == j)
            return;
        int m = (i + j) / 2;
        mergeSort(a, i, m);
        mergeSort(a, m + 1, j);
        interArrayInversionCount(a, i, m, m + 1, j);
    }

    public static void interArrayInversionCount(int a[], int s1, int e1, int s2, int e2) {
        int i = s1, j = s2, c = s1;
        int temp[] = new int[a.length];

        while (i <= e1 && j <= e2) {
            if (a[i] <= a[j])
                temp[c++] = a[i++];
            else {
                temp[c++] = a[j++];
                count += (e1 - i + 1);
            }
        }
        while (i <= e1) {
            temp[c++] = a[i++];
        }
        while (j <= e2) {
            temp[c++] = a[j++];
        }
        for (int k = s1; k <= e2; k++) {
            a[k] = temp[k];
            // System.out.println(a[k] + " ^");
        }
    }
}

// BRUTE FORCE
// public static void inversionCount(int a[]) {
// int count = 0;

// for (int i = 0; i < a.length; i++) {
// for (int j = i + 1; j < a.length; j++) {
// if (a[i] > a[j])
// count++;
// }
// }

// System.out.println(count);
// }