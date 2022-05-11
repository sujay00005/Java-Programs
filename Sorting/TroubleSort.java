package Sorting;

import java.util.Scanner;

public class TroubleSort {
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

        troubleSort(a);

        boolean flag = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                System.out.println(i);
                flag = false;
            }
        }
        if (flag)
            System.out.println("OK");

        // for (int i = 0; i < a.length; i++) {
        // System.out.print(a[i] + " ");
        // }
    }

    public static void troubleSort(int[] a) {

        boolean done = false;

        while (!done) {
            done = true;
            for (int i = 0; i < a.length - 2; i++) {
                if (a[i] > a[i + 2]) {
                    swap(a, i, i + 2);
                    done = false;
                }
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
