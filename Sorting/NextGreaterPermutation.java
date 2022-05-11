package Sorting;

import java.util.Scanner;

//Test for input 2 7 11 15     &      2 7 15 11
public class NextGreaterPermutation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number present in the array");
        int n = input.nextInt();

        System.out.println("Enter the elememts present in the array");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        // input.close();

        nextGreaterPermutation(a);

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }

    public static void nextGreaterPermutation(int[] a) {

        int x = a.length - 1;
        while (x > 0 && a[x] <= a[x - 1]) // finding when the descending order streak breaks
            x--;
        if (x - 1 >= 0) {
            for (int y = a.length - 1; y >= x; y--) { // looping till the streak breaking element
                if (a[y] > a[x - 1]) { // finding the smallest element greater than a[y] (i.e the streak breaking
                                       // element)
                    swap(a, y - 1, x);
                    break;
                }
            }
            int i = x, j = a.length - 1;
            while (i < j) { // reversing the array part which increasing to decreasing to get "next" greater
                            // permutaion
                swap(a, i, j);
                i++;
                j--;
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
