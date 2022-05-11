package Sorting;

import java.util.Scanner;

public class MergeSortedArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of points present ");
        int n = input.nextInt();

        int a[] = new int[n];

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        System.out.println("Enter the number of points present in second array");
        int n2 = input.nextInt();

        int b[] = new int[n2];

        System.out.println("Enter the elements of the second array");
        for (int i = 0; i < n2; i++) {
            b[i] = input.nextInt();
        }
        input.close();

        merge(a, b);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void merge(int a[], int b[]) {
        int i = 0, j = 0;
        int temp[] = new int[a.length];
        int c = 0;

        while (i < a.length && a[i] != 0 && j <= b.length) {
            if (a[i] <= b[j]) {
                temp[c++] = a[i++];
            } else {
                temp[c++] = b[j++];
            }
        }
        while (i < a.length && a[i] != 0)
            temp[c++] = a[i++];
        while (j < b.length)
            temp[c++] = b[j++];

        for (int k = 0; k < temp.length; k++) {
            a[k] = temp[k];
        }
    }

    public static void swap(int a[], int b[], int i, int j) {
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }
}
