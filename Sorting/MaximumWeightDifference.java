package Sorting;

import java.util.Scanner;

public class MaximumWeightDifference {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of items present ");
        int n = input.nextInt();

        System.out.println("Enter the value of K denoting the number of elements present in one group");
        int k = input.nextInt();

        int a[] = new int[n];
        System.out.println("Enter the weight of those elements");
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        input.close();

        mergeSort(a, 0, n - 1);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");

        int sonSum = 0;
        int dadSum = 0;
        for (int i = 0; i < a.length; i++) {
            if (i < k)
                sonSum += a[i];
            else
                dadSum += a[i];
        }
        System.out.println(dadSum - sonSum);
    }

    public static void mergeSort(int[] a, int i, int j) {
        if (i == j)
            return;
        int m = (i + j) / 2;
        mergeSort(a, i, m);
        mergeSort(a, m + 1, j);
        merge(a, i, m, m + 1, j);
    }

    public static void merge(int[] a, int s1, int e1, int s2, int e2) {
        int i = s1, j = s2, c = s1;
        int temp[] = new int[a.length];

        while (i <= e1 && j <= e2) {
            if (a[i] < a[j])
                temp[c++] = a[i++];
            else
                temp[c++] = a[j++];
        }
        while (i <= e1) {
            temp[c++] = a[i++];
        }
        while (j <= e2) {
            temp[c++] = a[j++];
        }
        for (int k = s1; k <= e2; k++)
            a[k] = temp[k];
    }
}
