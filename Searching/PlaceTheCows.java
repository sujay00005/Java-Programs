package Searching;

import java.util.Scanner;

public class PlaceTheCows {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements present(N) in the array");
        int n = input.nextInt();

        System.out.println("Enter the position of stalls in form of sorted array elements");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        System.out.println("Enter the value for number of test-cases");
        int t = input.nextInt();

        int cow[] = new int[t];
        for (int i = 0; i < t; i++) {
            cow[i] = input.nextInt();
        }
        input.close();

        for (int i = 0; i < t; i++) {
            System.out.println(placeCows(a, cow[i]));
        }
    }

    public static int placeCows(int[] a, int cows) {
        int length = a.length;
        int m;
        int high = a[length - 1] - a[0];
        int low = Integer.MAX_VALUE;
        for (int i = 0; i < length - 2; i++) {
            if (a[i + 1] - a[i] < low)
                low = a[i];
        }
        while (low <= high) {
            m = (low + high) / 2;
            boolean r = greedy(a, m, cows, length);
            if (!r)
                high = m - 1;
            else {
                boolean r1 = greedy(a, m + 1, cows, length);
                if (!r1)
                    return m;
                else
                    low = m + 1;
            }
        }
        return -1;
    }

    public static boolean greedy(int[] a, int m, int cows, int noOfStalls) {
        int count = 1;
        int pre = a[0];

        for (int i = 1; i < noOfStalls; i++) {
            if (a[i] - pre < m)
                continue;
            else {
                count++;
                pre = a[i];
            }
        }
        return count >= cows;
    }
}
