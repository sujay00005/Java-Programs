package Sorting;

import java.util.Scanner;

public class SquareOfSortedArray {
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

        sortSquare(a);
        for (int i = 0; i < n; i++) {
            System.out.println(a[i] + "*");
        }
    }

    public static void sortSquare(int a[]) {
        int i = 0, j = a.length - 1, c = a.length - 1;
        int temp[] = new int[a.length];

        for (int k = 0; k < temp.length; k++) {
            a[k] = a[k] * a[k];
        }

        while (i <= j) {
            if (a[i] > a[j])
                temp[c--] = a[i++];
            else
                temp[c--] = a[j--];
        }

        for (int k = 0; k < temp.length; k++) {
            a[k] = temp[k];
        }
    }
}
