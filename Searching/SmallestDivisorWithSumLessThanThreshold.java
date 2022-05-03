package Searching;

import java.util.Scanner;

public class SmallestDivisorWithSumLessThanThreshold {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of number of elements present in the matrix");
        int n = input.nextInt();

        System.out.println("Enter the array elements");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        System.out.println("Enter the value of threshold");
        int k = input.nextInt();
        input.close();

        System.out.println(sumLessThanThreshold(a, k));
    }

    public static int sumLessThanThreshold(int[] a, int k) {
        int l = 1, h = a[a.length - 1], m;

        while (l <= h) {
            m = (l + h) / 2;

            boolean r = greedy(a, m, k);
            if (!r)
                h = m - 1;
            else {
                boolean r1 = greedy(a, m - 1, k);
                if (!r1)
                    return m;
                else
                    l = m + 1;
            }
        }
        return -1;
    }

    public static boolean greedy(int[] a, int m, int k) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % m != 0)
                sum += (a[i] / m) + 1;
            else
                sum += a[i] / m;
        }
        System.out.println("*" + sum);
        return sum <= k;
    }
}
