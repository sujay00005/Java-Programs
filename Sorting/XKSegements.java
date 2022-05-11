package Sorting;

import java.util.Scanner;

public class XKSegements {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements present in the array");
        int n = input.nextInt();

        System.out.println("Enter the numbers from the segment");
        int x = input.nextInt();
        int k = input.nextInt();

        System.out.println("Enter the array elements");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
    }
}
