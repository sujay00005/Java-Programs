package Searching;

import java.util.Scanner;

public class MinimumSizeSubarray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements present in the array");

        int n = input.nextInt();
        System.out.println("Enter the elements of the array");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        System.out.println("Enter the number of testcases present");
        int t = input.nextInt();

        int cases[] = new int[t];
        for (int i = 0; i < t; i++) {
            cases[i] = input.nextInt();
        }

        input.close();
        for (int i : cases) {
            // brute(a, i);
            System.out.println(maxSubarraySize(a, i));
        }
    }

    public static int maxSubarraySize(int[] a, int targetSum) {
        int l = 0, h = a.length - 1;
        int m;

        while (l <= h) {
            m = (l + h) / 2;
            // m is window size here
            boolean r = greedy(a, m, targetSum);

            if (!r)
                h = m - 1;
            else {
                boolean r1 = greedy(a, m + 1, targetSum);
                if (!r1)
                    return m;
                else
                    l = m + 1;
            }
        }
        return 0;
    }

    public static boolean greedy(int[] a, int m, int targetSum) {
        if (m == a.length + 1)
            return false;
        int sum = 0;
        for (int i = 0; i < m; i++)
            sum += a[i];
        if (sum > targetSum)
            return false;
        for (int i = m; i < a.length; i++) {
            sum = sum + a[i] - a[i - m];
            if (sum > targetSum)
                return false;
        }
        return true;
    }
}

// BRUTE FORCE(needs fixation)

// public static void brute(int[] a, int targetSum) {
// int max = 0;
// for (int k = 1; k < a.length + 1; k++) { // for window size
// int sum = 0;
// for (int i = 0; i < k; i++) // sum for that window
// sum += a[i];
// // System.out.println(sum + " +");
// if (sum > targetSum)
// break;
// for (int i = k; i < a.length; i++) { // for other windows
// sum = sum + a[i] - a[i - k];
// if (sum > targetSum)
// break;
// if (i == a.length - 1) {
// if (k > max) {
// max = k;
// }
// }
// }
// }
// System.out.println(max);
// }