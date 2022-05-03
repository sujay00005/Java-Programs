package Searching;

import java.util.Scanner;

public class MonitorPixels {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(
                "Enter the lenght and width of the monitor, side of square such that the monitor is considered broken and the number of broken pixels");
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
        int q = input.nextInt();

        int x[] = new int[q];
        int y[] = new int[q];
        int t[] = new int[q];
        for (int i = 0; i < q; i++) {
            x[i] = input.nextInt();
            y[i] = input.nextInt();
            t[i] = input.nextInt();
        }

        for (int i = 0; i < q; i++) {
            System.out.println(isBroken(n, m, k, q, x, y, t));
        }

    }

    public static int isBroken(int n, int m, int k, int q, int[] x, int[] y, int[] t) {

        return -1;
    }

    public static boolean greedy() {

        return false;
    }
}
