package Sorting;

import java.util.HashMap;
import java.util.Scanner;

public class PossibleSextuple {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements present in the set S");
        int n = input.nextInt();

        int a[] = new int[n];
        System.out.println("Enter the elements present in the set");
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        input.close();
        System.out.println(noOfSextuples(a));
    }

    public static int noOfSextuples(int[] a) {
        int rhs[] = new int[a.length * a.length * a.length];
        int lhs[] = new int[a.length * a.length * a.length];

        int c = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a.length; k++) {
                    lhs[c++] = a[i] * a[j] + a[k];
                }
            }
        }

        int c2 = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0)
                continue; // since d can't be zero
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a.length; k++) {
                    rhs[c2++] = (a[i] + a[j]) * a[k];
                }
            }
        }
        for (int i = 0; i < rhs.length; i++) {
            System.out.println(lhs[i] + "***" + rhs[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < rhs.length; i++) {
            if (map.get(rhs[i]) == null)
                map.put(rhs[i], 1);
            else
                map.put(rhs[i], map.get(rhs[i]) + 1);
        }

        int count = 0;
        for (int i = 0; i < lhs.length; i++) {
            if (map.get(lhs[i]) != null)
                count += map.get(lhs[i]);
        }
        return count;
    }
}

// public static int noOfSextuples(int[] a) {
// int rhs[] = new int[a.length * a.length * a.length];
// int lhs[] = new int[a.length * a.length * a.length];

// int c = 0;
// for (int i = 0; i < a.length; i++) {
// for (int j = 0; j < a.length; j++) {
// for (int k = 0; k < a.length; k++) {
// lhs[c++] = a[i] * a[j] + a[k];
// }
// }
// }

// int c2 = 0;
// for (int i = 0; i < a.length; i++) {
// if (a[i] == 0)
// continue; // since d can't be zero
// for (int j = 0; j < a.length; j++) {
// for (int k = 0; k < a.length; k++) {
// rhs[c2++] = (a[i] + a[j]) * a[k];
// }
// }
// }
// for (int i = 0; i < rhs.length; i++) {
// System.out.println(lhs[i] + "***" + rhs[i]);
// }
// mergeSort(rhs, 0, rhs.length - 1);
// for (int i = 0; i < rhs.length; i++) {
// System.out.println(rhs[i]);
// }

// int count = 0;
// for (int i = 0; i < lhs.length; i++)
// count += count(lhs[i], rhs);

// return count;
// }

// public static int count(int k, int[] a) {
// int count = 0;
// for (int i = 0; i < a.length; i++) {
// if (a[i] == k)
// count++;
// }
// return count;
// }

// public static void mergeSort(int[] a, int i, int j) {
// if (i == j)
// return;
// int m = (i + j) / 2;
// mergeSort(a, i, m);
// mergeSort(a, m + 1, j);
// merge(a, i, m, m + 1, j);
// }

// public static void merge(int[] a, int s1, int e1, int s2, int e2) {
// int i = s1, j = s2, c = s1;
// int temp[] = new int[a.length];

// while (i <= e1 && j <= e2) {
// if (a[i] > a[j])
// temp[c++] = a[i++];
// else
// temp[c++] = a[j++];
// }
// while (i <= e1) {
// temp[c++] = a[i++];
// }
// while (j <= e2) {
// temp[c++] = a[j++];
// }
// for (int k = s1; k <= e2; k++)
// a[k] = temp[k];
// }
// }