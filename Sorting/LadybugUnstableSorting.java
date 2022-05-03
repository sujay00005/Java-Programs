package Sorting;

// unstable sort in order (NlogN) time

import java.util.Scanner;

public class LadybugUnstableSorting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements present in the array");
        int n = input.nextInt();

        int[] a = new int[n];
        System.out.println("Enter the array elements");
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        unstableMergeSort(a, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }

    public static void unstableMergeSort(int[] a, int i, int j) {
        if (i == j)
            return;
        int m = (i + j) / 2;
        unstableMergeSort(a, i, m);
        unstableMergeSort(a, m + 1, j);
        merge(a, i, m, m + 1, j);
    }

    public static void merge(int[] a, int s1, int e1, int s2, int e2) {
        int i = s1, j = s2, c = s1;
        int temp[] = new int[a.length];

        while (i <= e1 && j <= e2) {
            if (a[i] <= a[j])
                temp[c++] = a[j++];
            else
                temp[c++] = a[i++];
        }
        while (i <= e1) {
            temp[c++] = a[i++];
        }
        while (j <= e2) {
            temp[c++] = a[j++];
        }
        for (int k = 0; k <= e2; k++) {
            a[k] = temp[k];
        }
    }
}
