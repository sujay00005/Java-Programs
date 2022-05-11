package Sorting;

import java.util.Scanner;

public class AddOrNotAdd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(
                "Enter the number of elements present in the array and the number of operation we are allowed to perform");
        int n = input.nextInt();
        int k = input.nextInt();

        System.out.println("Enter the elements present in the array");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        mergeSort(a, 0, n - 1);
        addOrNot(a, n, k);

    }

    public static void addOrNot(int[] a, int n, int k) {

        int difference[] = new int[n - 1];
        for (int i = 0; i < a.length - 1; i++) {
            difference[i] = a[i + 1] - a[i];
            System.out.println(difference[i]);
        }

        int startIndex = 0;
        int endIndex = 0;
        int noOfElements = 0;
        int maxOccurance = 0, maxOccuredElement = 0;
        int tempK = k;
        for (int i = 0; i < difference.length; i++) {
            for (int j = i; j < difference.length; j++) {
                if (difference[j] < tempK) {
                    endIndex = j - 1;
                    break;
                }
                if (tempK > 0) {
                    if (tempK == k)
                        startIndex = j;
                    tempK -= difference[j];
                }
            }
            if (maxOccurance < endIndex - startIndex + 2)
                maxOccurance = endIndex - startIndex + 2;
            if (i - 1 >= 0 && maxOccuredElement < a[i - 1])
                maxOccuredElement = a[i - 1];
        }
        System.out.println(maxOccurance + " " + maxOccuredElement);

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
