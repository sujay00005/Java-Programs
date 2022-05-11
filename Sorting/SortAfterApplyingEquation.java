package Sorting;

import java.util.Scanner;

public class SortAfterApplyingEquation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of 'A', 'B' and 'C'");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        System.out.println("Enter the number of points present ");
        int n = input.nextInt();

        int array[] = new int[n];

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        input.close();

        sortArray(array, a, b, c);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void sortArray(int array[], int a, int b, int c) {
        // int monotonicPoint = -b / (2 * a);
        for (int i = 0; i < array.length; i++) {
            array[i] = (a * array[i] * array[i]) + (b * array[i]) + c;
        }
        merge(array);
        // monotonicPoint);

    }

    public static void merge(int a[]) {
        int i = 0, j = a.length - 1, c = 0;
        int temp[] = new int[a.length];

        while (i <= j) {
            if (a[i] > a[j])
                temp[c++] = a[j--];
            else
                temp[c++] = a[i++];
        }

        for (int k = 0; k < temp.length; k++) {
            a[k] = temp[k];
        }
    }
}
