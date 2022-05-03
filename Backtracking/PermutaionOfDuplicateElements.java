package Backtracking;

import java.util.HashMap;
import java.util.Scanner;

public class PermutaionOfDuplicateElements {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements present in the array");
        int n = input.nextInt();

        System.out.println("Enter the array elements");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        input.close();
        premutation(a, 0);
    }

    public static void premutation(int[] a, int currPosition) {
        if (currPosition == a.length - 1) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]);
            }
            System.out.println("");
            return;
        }
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = currPosition; i < a.length; i++) {
            if (freq.get(a[i]) == null) {
                // swap
                int temp = a[currPosition];
                a[currPosition] = a[i];
                a[i] = temp;
                premutation(a, currPosition + 1);
                // unswap
                temp = a[currPosition];
                a[currPosition] = a[i];
                a[i] = temp;
            }
            freq.put(a[i], 1);
        }

    }
}
