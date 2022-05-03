package Searching;

import java.util.Scanner;

public class KthSmallestPairDistance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements present in the array");
        int n = input.nextInt();

        System.out.println("Enter the sorted array elements");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        System.out.println("Enter the value of k to find the kth smallest element of the array");
        int k = input.nextInt();
        // input.close();

        System.out.println();
    }
}
