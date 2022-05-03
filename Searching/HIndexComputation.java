package Searching;

import java.util.Scanner;

public class HIndexComputation {
    public static int max = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements present in the array");
        int n = input.nextInt();

        System.out.println("Enter the sorted array element");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        input.close();

        System.out.println(a[valueOfH((a))]);
    }

    public static int valueOfH(int[] citation) {
        int l = 0;
        int h = citation.length;
        int m;
        // int max = 0;
        while (l <= h) {
            m = (l + h) / 2;
            if (citation[m] >= m) {
                if (citation[m - 1] <= m) {
                    // max = max >= m ? max : m;
                    // l = m + 1;
                    return m;
                } else
                    h = m - 1;

            } else {
                l = m + 1;
            }
        }
        // return max;
        return -1;
    }
}
