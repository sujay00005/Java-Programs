package Searching;

import java.util.Scanner;

public class KthSmallestInArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements present in the array");
        int n = input.nextInt();

        System.out.println("Enter the sorted array elements");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        System.out.println("Enter the value of k to find the kth smallest element of the array");
        int k = input.nextInt();
        input.close();

        System.out.println(kthSmallest(a, k));
    }

    public static int kthSmallest(int[] a, int k) {

        // For max and min element of the array
        int l = Integer.MAX_VALUE, h = Integer.MIN_VALUE, m;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < l)
                l = a[i];
            if (a[i] > h)
                h = a[i];
        }

        while (l <= h) {
            m = (l + h) / 2;
            // count holds no. of times m appears
            int count = count(a, m);
            // case of strictly smaller
            if (count < k)
                l = m + 1;
            else { // case of count >= k
                count = count(a, m - 1);
                // when at ans
                if (count < k)
                    return m;
                // when not at ans
                else
                    h = m - 1;
            }

        }
        // does not fall in this range
        return -1;
    }

    // no.s smaller than m
    public static int count(int[] a, int m) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= m)
                count++;
        }
        return count;
    }
}

// O(N*N) method
// public static int kthSmallest(int[] a, int k) {

// for (int i = 0; i < a.length; i++) {
// int strictlySmaller = 0, equal = 0;
// for (int j = 0; j < a.length; j++) {
// if (a[j] < a[i])
// strictlySmaller++;
// else if (a[j] == a[i])
// equal++;
// }
// if (strictlySmaller + equal >= k && strictlySmaller < k)
// return a[i];
// }
// // does not fall in this range
// return -1;
// }
