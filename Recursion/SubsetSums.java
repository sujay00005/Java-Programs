package Recursion;

import java.util.Scanner;

public class SubsetSums {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements present in the array");
        int n = input.nextInt();

        System.out.println("Enter the array elements");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        input.close();

        subsetSum(a, -1, 0);
    }

    public static void subsetSum(int[] a, int index, int sum) {
        if (index == a.length - 1) {
            System.out.println(sum);
            return;
        }
        // NO Branch
        subsetSum(a, index + 1, sum);
        // YES Branch
        subsetSum(a, index + 1, sum + a[index + 1]);
        sum = sum - a[index + 1];
    }
}
