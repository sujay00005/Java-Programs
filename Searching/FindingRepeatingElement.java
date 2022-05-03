package Searching;

import java.util.Scanner;

public class FindingRepeatingElement {
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

        int repeatingIndex = RepeatingElementIndex(a);
        if (repeatingIndex >= 0)
            System.out.println(a[repeatingIndex]);
    }

    public static int RepeatingElementIndex(int[] a) {
        int h = a.length - 1;
        int l = 0;
        int m;

        while (l <= h) {
            m = (l + h) / 2;
            if (a[m] > m)
                l = m + 1;
            else {
                if (a[m - 1] == a[m])
                    return m;
                else
                    h = m - 1;
            }
        }
        return -1;
    }

}
