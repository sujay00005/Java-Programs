package Sorting;

import java.util.Scanner;

public class BubbleSort {
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

        bubbleSort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void bubbleSort(int[] a) {

        boolean done = false;

        while (!done) {
            done = true;
            int i = 0;

            while (i < a.length - 1) {
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    done = false;
                }
                i++;
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
