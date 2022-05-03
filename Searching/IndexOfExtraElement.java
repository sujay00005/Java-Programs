package Searching;

import java.util.Scanner;

public class IndexOfExtraElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements present in the array with extra element");
        int n = input.nextInt();

        System.out.println("Enter the sorted array with extra element");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        System.out.println("Enter the sorted normal array element");
        int[] b = new int[n];
        for (int i = 0; i < n - 1; i++) {
            b[i] = input.nextInt();
        }
        input.close();

        System.out.println(a[indexOfExtras(a, b)]);
    }

    public static int indexOfExtras(int[] a, int[] b) {
        int l = 0;
        int h = b.length;
        int m;
        while (l <= h) {
            m = (l + h) / 2;
            if (a[m + 1] == b[m]) {
                h = m - 1;
            } else { // a[m] ==b[m]
                if (m + 1 < b.length - 1 && a[m + 1] != b[m + 1])
                    return m + 1;
                else
                    l = m + 1;
            }
        }
        return -1;
    }

}
