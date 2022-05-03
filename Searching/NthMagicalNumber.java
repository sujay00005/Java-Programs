package Searching;

import java.util.Scanner;

public class NthMagicalNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of test-cases present");
        int t = input.nextInt();

        int n[] = new int[t];
        int a[] = new int[t];
        int b[] = new int[t];
        for (int i = 0; i < t; i++) {
            System.out.println("Enter the value of n, a and b for " + (i + 1) + "th test case");
            n[i] = input.nextInt();
            a[i] = input.nextInt();
            b[i] = input.nextInt();
        }
        input.close();

        for (int i = 0; i < t; i++) {
            System.out.println(NthMagicNo(n[i], a[i], b[i]));
        }

    }

    public static int NthMagicNo(int n, int a, int b) {
        int count = 1;
        int currvalue;

        int multiplyA = 1;
        int multiplyB = 1;
        if (a < b) {
            multiplyA = 2;
            multiplyB = 1;
            currvalue = a;
        } else {
            multiplyA = 1;
            multiplyB = 2;
            currvalue = b;
        }

        while (count < n) {
            int x = a * multiplyA;
            int y = b * multiplyB;

            if (x > y) {
                currvalue = y;
                multiplyB++;
                count++;
            } else if (x < y) {
                currvalue = x;
                multiplyA++;
                count++;
            } else {
                currvalue = x;
                multiplyA++;
                multiplyB++;
                count++;
            }
        }
        return currvalue;
    }
}
