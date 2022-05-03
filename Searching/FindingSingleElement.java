package Searching;

import java.util.Scanner;

public class FindingSingleElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements present in the array");
        int n = input.nextInt();

        System.out.println("Enter the sorted array elements");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        input.close();

        int repeatingIndex = singleElementIndex(a);
        if (repeatingIndex >= 0)
            System.out.println(a[repeatingIndex]);
    }

    public static int singleElementIndex(int[] a) {
        int l = 0;
        int h = a.length;
        int m;
        while (l <= h) {
            m = (l + h) / 2;
            // if(m==0)
            if (m % 2 == 0) {

                if (m + 1 < a.length - 1 && a[m] == a[m + 1]) {
                    l = m + 2;
                } else if (m - 1 >= 0 && a[m] == a[m - 1]) {
                    h = m - 2;
                } else {
                    return m;
                }
            } else {
                if (m - 1 >= 0 && a[m] == a[m - 1]) {
                    l = m + 1;
                } else if (m + 1 < a.length - 1 && a[m] == a[m + 1]) {
                    h = m - 1;
                } else {
                    return m;
                }
            }
        }

        return -1;
    }
}
