package Searching;

import java.util.Scanner;

public class CapacityToShipPackages {
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

        System.out.println("Enter the number of days for each test cases");
        int cases[] = new int[t];
        for (int i = 0; i < t; i++) {
            cases[i] = input.nextInt();
        }

        input.close();
        for (int i : cases) {
            System.out.println(shipPackages(a, i));
        }
    }

    public static int shipPackages(int[] cargo, int days) {
        int l = 0;
        int h = 0, m;

        for (int i = 0; i < cargo.length; i++) {
            h += cargo[i];
            if (l < cargo[i])
                l = cargo[i];
        }

        while (l <= h) {
            m = (l + h) / 2;
            // m is the amount of cargo to be transported in a single day
            boolean r = greedy(cargo, m, days);
            if (!r)
                l = m + 1;
            else {
                boolean r1 = greedy(cargo, m - 1, days);
                if (!r1)
                    return m;
                else
                    h = m - 1;
            }
        }
        return 0;
    }

    public static boolean greedy(int[] a, int m, int targetDays) {
        int count = 1;
        // starting with 1 because as soon as we enter in for loop, we are counting for
        // first 1st case
        int currValue = 0;
        for (int i = 0; i < a.length; i++) {
            if (currValue + a[i] > m) {
                // because no. of packages can be less than m but not grater than that
                count++;
                currValue = a[i];
            } else {
                currValue += a[i];
            }
        }
        return count <= targetDays;
    }
}
