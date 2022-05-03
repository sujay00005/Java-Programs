package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of points present");
        int n = input.nextInt();

        int a[] = new int[n];

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        input.close();

        radixSort(a, n);

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixSort(int arr[], int n) {
        // Find the maximum number to know number of digits
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            if (arr[i] > max)
                max = arr[i];

        // Do counting sort for every digit.
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    static void countSort(int arr[], int n, int exp) {
        int temp[] = new int[n]; // output array
        int freq[] = new int[10];
        Arrays.fill(freq, 0);

        // Store count of occurrences in freq[]
        for (int i = 0; i < n; i++)
            freq[(arr[i] / exp) % 10]++;

        // Change freq[i] so that freq[i] now contains
        // actual position of this digit in temp[] (i.e cumulative frequency )
        for (int i = 1; i < 10; i++)
            freq[i] += freq[i - 1];

        // Build the output(temp) array
        for (int i = n - 1; i >= 0; i--) {
            temp[freq[(arr[i] / exp) % 10] - 1] = arr[i];
            freq[(arr[i] / exp) % 10]--;
        }

        // Copy the output(temp) array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (int i = 0; i < n; i++)
            arr[i] = temp[i];
    }
}

// int i = 10;
// int place =1;

// while (i <= factor) {

// System.out.println(i + "************");

// int freq[] = new int[10];// because we are storing frequency of 0-9
// Arrays.fill(freq, 0);

// for (int j = 0; j < l; j++) { // for frequency
// freq[temp[j] % i]++;
// temp[j] /= 10;
// }

// for (int j = 1; j < 10; j++) // for cumulative frequency
// freq[j] += freq[j - 1];

// // for (int j = 0; j < 10; j++)
// // System.out.println(j + " {{}} " + freq[j]);
// for (int j = l - 1; j >= 0; j--) { // sorting based on the place value of
// i/10
// System.out.println(freq[(a[j] % i) % 10]);
// // temp[freq[a[j] % i]] = a[j];
// // freq[a[j] / i]--;
// }

// for (int j = 0; j < l; j++) // copying back to original array
// a[j] = temp[j];
// i = i * 10;
// }