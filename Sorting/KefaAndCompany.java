package Sorting;

import java.util.Scanner;

public class KefaAndCompany {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of friends present");
        int n = input.nextInt();

        System.out.println("Enter the minimum difference of money in order to feel poor");
        int moneyDiff = input.nextInt();

        System.out.println("Enter the amount of money and the friendship factor for each friend");
        int friend[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the detail for the " + (i + 1) + "th frined");
            friend[i][0] = input.nextInt();
            friend[i][1] = input.nextInt();
        }

        System.out.println(maxFriendship(n, moneyDiff, friend));
        // for (int i = 0; i < friend.length; i++) {
        // System.out.println(friend[i][0] + " " + friend[i][1]);
        // }
    }

    public static int maxFriendship(int n, int moneyDiff, int a[][]) {
        // insertionSort(n, a);

        // can use two pointer instead of this
        int friendship[] = new int[n];

        for (int i = 0; i < n; i++) {
            // boolean flag = true;
            for (int j = i; j < n; j++) {
                if ((int) Math.abs(a[i][0] - a[j][0]) < moneyDiff) {
                    friendship[i] += a[j][1];
                    // flag = false;
                    // System.out.println("BREAK");
                    // break;
                }
            }

        }

        int max = friendship[0];
        for (int i = 0; i < n; i++) {
            if (friendship[i] > max)
                max = friendship[i];
        }
        return max;
    }

    public static void insertionSort(int n, int a[][]) {

        for (int i = 1; i < a.length; i++) {
            int j = i;
            while (j > 0 && a[j - 1][0] > a[j][0]) {
                swap(a, j, j - 1);
                j--;
            }
        }
    }

    public static void swap(int a[][], int i, int j) {
        int temp = a[i][0];
        a[i][0] = a[j][0];
        a[j][0] = temp;
    }
}
