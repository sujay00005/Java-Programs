package Searching;

import java.util.Scanner;

public class MagicPowder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the value of number of ingredients present and the grams of magic powder present");
        int n = input.nextInt();
        long gramsOfMagic = input.nextLong();

        System.out.println("Enter the value of n, ith ingredient 'needed' to bake cookies");
        long a[] = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextLong();
        }
        System.out.println("Enter the value of n, ith ingredient 'present' to bake cookies");
        long b[] = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = input.nextLong();
        }

        input.close();
        System.out.println(magicPowder(gramsOfMagic, a, b));
    }

    public static long magicPowder(long gramsOfMagic, long[] a, long[] b) {
        long l = (long) 0, h = b[0], m;

        for (int i = 0; i < b.length; i++) {
            if (h < b[i])
                h = b[i];
        }

        while (l <= h) {
            m = (l + h) / 2;

            boolean r = greedy(m, gramsOfMagic, a, b);
            if (!r)
                h = m - 1;

            else {
                boolean r1 = greedy(m + 1, gramsOfMagic, a, b);
                if (!r1)
                    return m;
                else
                    l = m + 1;
            }
        }
        return 0;
    }

    public static boolean greedy(long m, long gramsOfMagic, long[] a, long[] b) {
        long needed[] = new long[a.length];
        for (int i = 0; i < a.length; i++) {
            needed[i] = m * a[i];
        }
        long gramsNeeded = 0;
        for (int i = 0; i < a.length; i++) {
            if (needed[i] > b[i])
                gramsNeeded = needed[i] - b[i];
        }
        System.out.println(gramsNeeded + "-------" + (gramsNeeded <= gramsOfMagic) + "---" + m);
        return gramsNeeded <= gramsOfMagic;
    }
}
