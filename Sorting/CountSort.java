package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class CountSort {
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

        countSort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void countSort(int[] a) {

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min)
                min = a[i];
            if (a[i] > max)
                max = a[i];
        }

        System.out.println(min + "---------" + max);
        int freq[] = new int[max - min + 1];

        Arrays.fill(freq, 0);

        // for frequency
        for (int i = 0; i < a.length; i++)
            freq[a[i] - min]++;
        // frequency of the min element will be stored in the 0th index and max element
        // at the end of the array

        // for cumulative frequency
        for (int i = 1; i < freq.length; i++)
            freq[i] += freq[i - 1];

        int ans[] = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            ans[freq[a[i] - min] - 1] = a[i];
            freq[a[i] - min]--;
        }

        System.out.println("Sorted array is : ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println("");

    }
}
