package Searching;

import java.util.Scanner;

public class IndexOfInsertion {
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
            int k = insert(key[i], a);

            System.out.println(k);
        }

    }

    public static int insert(int key, int[] a) {
        int l = 0;
        int h = a.length;
        int m;
        while (l <= h) {
            m = (l + h) / 2;
            if (m >= a.length)
                return a.length;
            if (m < 0)
                return 0;
            if (a[m] == key)
                return m;
            else if (a[m] > key)
                h = m - 1;
            else
                l = m + 1;
        }

        return l;
    }
}
