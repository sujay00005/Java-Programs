package Sorting;

import java.util.Scanner;

public class LargestNumber {
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

        sort(a, n);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static void sort(int[] a, int n) {
        int max = a[0], min = a[0];

        for (int i = 1; i < n; i++) {
            if (max < a[i])
                max = a[i];
            if (min > a[i])
                min = a[i];
        }
        System.out.println(min + " : " + max);

        int maxNoDigits = noOfDigits(max);
        int minNoDigits = noOfDigits(min);

        int temp[] = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = (a[i] / (int) Math.pow(10, noOfDigits(a[i]) - 1) % 10);
        }
        // for (int i = 0; i < n; i++) {
        // System.out.println(temp[i]);
        // }
        insertionSort(a, temp, n);

        int sameStartIndex = -1, sameEndIndex = -1;
        for (int i = 1; i < temp.length; i++) {
            if (i == 1 && temp[i] == temp[i - 1]) {
                sameStartIndex = 0;
            } else if (temp[i] == temp[i - 1] && temp[i] != temp[i - 2]) {
                sameStartIndex = i - 1;
            }
            if (sameStartIndex >= 0 && temp[i] != temp[i - 1]) {
                sameEndIndex = i - 1;
            }

        }

        // for (int i = 0; i < n; i++) {
        // System.out.println(temp[i]);
        // }
    }

    public static void insertionSort(int a[], int[] temp, int n) {

        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && temp[j - 1] < temp[j]) {
                swap(temp, j, j - 1);
                swap(a, j, j - 1);
                j--;
            }
        }

        for (int i = 1; i < n; i++) {
            int j = i;
            if (j > 0 && temp[j] == temp[j - 1]) {

            }
        }
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int noOfDigits(int n) {
        int copy = n, digits = 0;
        while (copy > 0) {
            copy /= 10;
            digits++;
        }
        return digits;
    }
}
