package Searching;

import java.util.Scanner;

public class RotateSortedArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements present in the array");
        int n = input.nextInt();

        System.out.println("Enter the rotation sorted array elements");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        System.out.println("Enter the number of test cases present");
        int cases = input.nextInt();

        System.out.println("Enter the key for each test case");
        int key[] = new int[cases];
        for (int i = 0; i < cases; i++) {
            key[i] = input.nextInt();
        }
        input.close();

        int pivotIndex = pivotFinding(a);
        for (int i = 0; i < cases; i++) {
            int k = searchInRotated(key[i], a, pivotIndex);
            if (k >= 0)
                System.out.println(k);
            else
                System.out.println("-1 ");
        }

    }

    public static int searchInRotated(int key, int[] a, int pivotIndex) {
        int l, h;
        if (key < a[0]) {
            l = pivotIndex + 1;
            h = a.length - 1;
        } else {
            l = 0;
            h = pivotIndex;
        }
        int m;
        while (l <= h) {
            m = (l + h) / 2;
            if (a[m] == key)
                return m;
            else if (a[m] > key)
                h = m - 1;
            else
                l = m + 1;
        }
        return -1;
    }

    public static int pivotFinding(int[] a) {
        int h = a.length - 1, l = 0;
        int m;
        while (l <= h) {
            m = (l + h) / 2;
            if (m < 0 || m > a.length - 1)
                return 0;
            if (a[m] <= a[m - 1])
                h = m - 1;
            else {
                if (a[m] > a[m + 1]) {
                    return m;
                } else {
                    l = m + 1;
                }
            }
        }
        // when array already sorted, so that normal sorting takes place
        return a.length - 1;
    }
}
