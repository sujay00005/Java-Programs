package Sorting;

import java.util.Scanner;

public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the length of the three sides of the triangle");
        int a[] = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = input.nextInt();
        }
        input.close();
        System.out.println(triangle(a));
    }

    public static int triangle(int a[]) {
        if (a[0] > a[1] && a[0] > a[2])
            swap(a, 0, 2);
        if (a[1] > a[2])
            swap(a, 1, 2);
        if (a[0] > a[1])
            swap(a, 0, 1);

        System.out.println(a[0] + " " + a[1] + " " + a[2]);
        if (a[2] >= (a[0] + a[1]))
            return 0;
        else {
            return a[2] + a[1] + a[0];
        }
    }

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
