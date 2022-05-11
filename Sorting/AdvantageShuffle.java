package Sorting;

import java.util.Scanner;

public class AdvantageShuffle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of points present ");
        int n = input.nextInt();

        int a[] = new int[n];

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        int b[] = new int[n];

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            b[i] = input.nextInt();
        }
        // input.close();

        maximizeAdvantage(a, b, n);

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }

    public static void maximizeAdvantage(int[] a, int[] b, int n) {
        int adv = advantage(a, b);

        int maxAdv = adv;
        while (true) {
            int temp[] = new int[n];
            for (int i = 0; i < n; i++) {
                temp[i] = a[i];
            }
            nextGreaterPermutation(a);
            adv = advantage(a, b);
            if (adv > maxAdv)
                maxAdv = adv;

            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + "#");
            }
            boolean flag = true;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != a[i]) {
                    flag = false;
                }
                if (i == (temp.length - 1) && flag) {
                    break;
                }
            }
            System.out.println("");

        }
    }

    public static void nextGreaterPermutation(int[] a) {

        int x = a.length - 1;
        while (x > 0 && a[x] <= a[x - 1]) // finding when the descending order streak breaks
            x--;
        if (x - 1 >= 0) {
            for (int y = a.length - 1; y >= x; y--) { // looping till the streak breaking element
                if (a[y] > a[x - 1]) { // finding the smallest element greater than a[y] (i.e the streak breaking
                                       // element)
                    swap(a, y - 1, x);
                    break;
                }
            }
            int i = x, j = a.length - 1;
            while (i < j) { // reversing the array part which increasing to decreasing to get "next" greater
                            // permutaion
                swap(a, i, j);
                i++;
                j--;
            }
        }
    }

    public static int advantage(int[] a, int[] b) {
        int adv = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i])
                adv++;
        }
        return adv;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
