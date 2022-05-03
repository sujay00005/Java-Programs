package Searching;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of test cases");
        int n = input.nextInt();

        System.out.println("Enter the value for each test case");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        input.close();
        for (int j = 0; j < n; j++) {
            System.out.println(squareRootFloor(a[j]));
        }
    }

    public static int squareRootFloor(int k) {
        int l = 0;
        int h = k;
        int m;
        while (l <= h) {
            m = (l + h) / 2;
            if (m * m > k)
                h = m - 1;
            else {
                if ((m + 1) * (m + 1) > k)
                    return m;
                else
                    l = m + 1;
            }
        }
        return 0;
    }
}
