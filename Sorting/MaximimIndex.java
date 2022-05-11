package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MaximimIndex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of points present ");
        int n = input.nextInt();

        int a[] = new int[n];

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        // input.close();
        maximize(a);

    }

    public static void maximize(int a[]) {
        // int x[][] = new int[a.length][2];
        // for (int i = 0; i < a.length; i++) {
        // x[i][0] = a[i];
        // x[i][1] = i;
        // }
        Pair x[] = new Pair[a.length];

        for (int i = 0; i < a.length; i++) {
            x[i] = new Pair(a[i], i);
        }
        // for (int i = 0; i < x.length; i++) {
        // System.out.println(x[i].first + "---- " + x[i].second);
        // }
        mergeSort(x, 0, a.length - 1);
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i].first + " " + x[i].second);
        }
    }

    public static void mergeSort(Pair[] a, int i, int j) {
        if (i == j)
            return;
        int m = (i + j) / 2;
        mergeSort(a, i, m);
        mergeSort(a, m + 1, j);
        merge(a, i, m, m + 1, j);
    }

    public static void merge(Pair[] a, int s1, int e1, int s2, int e2) {
        int i = s1, j = s2, c = s1;
        Pair temp[] = new Pair[a.length];
        Pair dummy = new Pair(0, 0);
        Arrays.fill(temp, dummy);

        // for (int k = 0; k < a.length; k++) {
        // System.out.println(temp[k].first + " ^ " + temp[k].second);
        // }
        while (i <= e1 && j <= e2) {
            System.out.println(a[i].first + "   " + a[j].first);
            if (a[i].first < a[j].first) {
                temp[c].second = a[i].second;
                temp[c++].first = a[i++].first;
            } else {
                temp[c].second = a[j].second;
                temp[c++].first = a[j++].first;
            }
        }

        // for (int k = 0; k < temp.length; k++) {
        // System.out.println(temp[k].first + " ****** " + temp[k].second);
        // }

        while (i <= e1) {
            temp[c].second = a[i].second;
            temp[c++].first = a[i++].first;
        }
        while (j <= e2) {
            temp[c].second = a[j].second;
            temp[c++].first = a[j++].first;
        }
        for (int k = s1; k <= e2; k++)
            a[k] = temp[k];
    }
}

class Pair {
    int first, second;

    Pair(int f, int s) {
        first = f;
        second = s;
    }
}

// BRUTE FORCE
// public static void maximize(int a[]) {
// int max = 0;
// for (int i = 0; i < a.length; i++) {
// for (int j = 0; j < a.length; j++) {
// if (i != j && a[j] >= a[i]) {
// max = max > j - 1 ? max : j - 1;
// }
// }
// }

// System.out.println(max);
// }