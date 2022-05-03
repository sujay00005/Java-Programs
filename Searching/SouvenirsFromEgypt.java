package Searching;

import java.util.Scanner;

public class SouvenirsFromEgypt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(
                "Enter the number of items present in the market and the value of maximum Egyptian money to be spent");
        int n = input.nextInt();
        int s = input.nextInt();

        int a[] = new int[n];
        System.out.println("Enter the value of base cost of all the n items");
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        // input.close();

    }

    public static void maximumSouvenirs(int[] a, int s) {

    }

    public static int calculateCost(int[] a, int itemNumber, int totalSouvenirs) {

        return -1;
    }
}
