package Sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class RelativeSortArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of element present in the array to be sorted");
        int n1 = input.nextInt();

        System.out.println("Enter the array elements");
        int a[] = new int[n1];
        for (int i = 0; i < n1; i++) {
            a[i] = input.nextInt();
        }

        System.out
                .println("Enter the number of elements present in the array according to which sorting is to be done");
        int n2 = input.nextInt();

        System.out.println("Enter the array elements");
        int b[] = new int[n2];
        for (int i = 0; i < n2; i++) {
            b[i] = input.nextInt();
        }
        input.close();

        sort(a, b);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static void sort(int[] a, int[] b) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < a.length; j++)
                if (b[i] == a[j])
                    temp.add(a[j]);

        for (int i = 0; i < a.length; i++) {
            if (!temp.contains(a[i]))
                temp.add(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = temp.get(i);
        }
    }
}
