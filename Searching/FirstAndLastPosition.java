package Searching;

import java.util.Scanner;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements present in the array");
        int n = input.nextInt();

        System.out.println("Enter the sorted array elements");
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

        for (int i = 0; i < cases; i++) {
            int k = firstIndex(key[i], a);
            if (k >= 0) {
                System.out.println(k + "  **  " + lastIndex(key[i], a));
            } else {
                System.out.println("-1");
            }
        }

    }

    public static int firstIndex(int key, int[] a) {
        int l = 0;
        int h = a.length;
        int m;
        while (l <= h) {
            m = (l + h) / 2;
            if (a[m] > key)
                h = m - 1;
            else if (a[m] < key)
                l = m + 1;
            else if (m == 0)
                return m;
            else if (a[m - 1] != key)
                return m;
            else
                h = m - 1;
        }

        return -1;
    }

    public static int lastIndex(int key, int[] a) {
        int l = 0;
        int h = a.length;
        int m;
        while (l <= h) {
            m = (l + h) / 2;
            if (a[m] > key)
                h = m - 1;
            else if (a[m] < key)
                l = m + 1;
            else if (m == a.length - 1)
                return m;
            else if (a[m + 1] != key)
                return m;
            else
                l = m + 1;
        }

        return -1;
    }
}
