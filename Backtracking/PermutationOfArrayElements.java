package Backtracking;

import java.util.Scanner;

public class PermutationOfArrayElements {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements present in the array");
        int n = input.nextInt();

        System.out.println("Enter the array elements");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        input.close();
        premutation(a, 0);
    }

    public static void premutation(int[] a, int currPosition) {
        if (currPosition == a.length) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]);
            }
            System.out.println("");
            return;
        }

        for (int i = currPosition; i < a.length; i++) {
            // swap
            int temp = a[currPosition];
            a[currPosition] = a[i];
            a[i] = temp;
            premutation(a, currPosition + 1);
            // unswap
            temp = a[currPosition];
            a[currPosition] = a[i];
            a[i] = temp;
        }
    }
}