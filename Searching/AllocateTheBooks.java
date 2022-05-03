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
        input.close();

        System.out.println(allocate(a, student));
    }

    public static int allocate(int[] a, int student) {
        // max page present among all the books
        int l = Integer.MIN_VALUE;
        // sum of all pages
        int h = 0, m;
        for (int i : a) {
            h += i;
            if (l < i)
                l = i;
        }
        while (l <= h) {
            m = (l + h) / 2;
            // m reperesents no. of pages
            boolean r = greedy(a, m, student);
            if (!r)
                l = m + 1;
            else {
                boolean r1 = greedy(a, m - 1, student);
                if (!r1)
                    return m;
                else
                    h = m - 1;
            }
        }
        return -1;
    }

    public static boolean greedy(int[] a, int m, int student) {
        int count = 1;
        //starting with 1 because as soon as we enter in for loop, we are counting for first 1st case

        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            if (sum + a[i] > m) {
                // because no. of pages can be less than m but not grater than that
                count++;
                sum = a[i];
            } else {
                sum += a[i];
            }
        }
        return count <= student;
    }
}
