package Searching;

import java.util.Scanner;

public class NthUglyNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of test-cases present");
        int t = input.nextInt();

        int n[] = new int[t];
        int a[] = new int[t];
        int b[] = new int[t];
        int c[] = new int[t];
        for (int i = 0; i < t; i++) {
            System.out.println("Enter the value of n, a and b for " + (i + 1) + "th test case");
            n[i] = input.nextInt();
            a[i] = input.nextInt();
            b[i] = input.nextInt();
            c[i] = input.nextInt();
        }
        input.close();

        for (int i = 0; i < t; i++) {
            System.out.println(NthMagicNo(n[i], a[i], b[i], c[i]));
        }

    }

    public static int NthMagicNo(int n, int a, int b, int c) {
        int count = 1;
        int currvalue = a;

        int multiplyA = 2;
        int multiplyB = 1;
        int multiplyC = 1;

        while (count < n) {
            int x = a * multiplyA;
            int y = b * multiplyB;
            int z = c * multiplyC;

            if (x > y && z > y) {
                currvalue = y;
                multiplyB++;
                count++;
            } else if (x < y && x < z) {
                currvalue = x;
                multiplyA++;
                count++;
            } else if (z < y && z < x) {
                currvalue = z;
                multiplyC++;
                count++;
            } else {
                currvalue = x;
                multiplyA++;
                multiplyB++;
                multiplyC++;
                count++;
            }
        }
        return currvalue;
    }
}
