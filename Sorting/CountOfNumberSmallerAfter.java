package Sorting;

import java.util.Scanner;

public class CountOfNumberSmallerAfter {
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

        mergeSort(a, 0, n - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void mergeSort(int a[], int i, int j) {
        if (i == j)
            return;
        int m = (i + j) / 2;
        mergeSort(a, i, m);
        mergeSort(a, m + 1, j);
        numbersSmallerAfter(a, i, m, m + 1, j);
    }

    public static void numbersSmallerAfter(int a[], int s1, int e1, int s2, int e2) {
        int temp[] = new int[a.length];

    }
}

// BRUTE FORCE
// public static int[] numbersSmallerAfter(int a[]) {
// int counts[] = new int[a.length];
// for (int i = 0; i < a.length - 1; i++) {
// int count = 0;
// for (int j = i + 1; j < a.length; j++) {
// if (a[i] > a[j])
// count++;
// }
// counts[i] = count;
// }
// counts[a.length - 1] = 0;
// return counts;
// }