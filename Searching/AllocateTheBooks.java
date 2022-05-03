package Searching;

import java.util.Scanner;

public class AllocateTheBooks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of books present");
        int n = input.nextInt();

        System.out.println("Enter the number of pages present in all these n books");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        System.out.println("Enter the value for number of students present");
        int student = input.nextInt();
        // input.close();

        System.out.println(allocate(a));
    }

    public static int allocate(int[] a) {
        int l = a[0];
        int h = 0, m;
        for (int i : a) {
            h += i;
        }

        while (l <= h) {
            m = (l + h) / 2;
            boolean r = greedy(a, m);
        }
        return -1;
    }

    public static boolean greedy(int[] a, int m) {

    }
}
