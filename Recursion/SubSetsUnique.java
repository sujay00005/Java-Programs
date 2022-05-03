package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubSetsUnique {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of elements present in the array");
        int n = input.nextInt();

        int[] a = new int[n];
        System.out.println("Enter the array elements");
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        input.close();
        List<Integer> temp = new ArrayList<Integer>();
        subArray(a, n, 0, temp, 0);
    }

    public static void subArray(int[] a, int n, int index, List<Integer> temp, int currIndex) {
        if (n == index) {
            System.out.println(temp);
            return;
        }
        subArray(a, n, index + 1, temp, currIndex); // for 'NO' branch of recursion
        temp.add(a[index]); // for 'YES' branch of recursion
        subArray(a, n, index + 1, temp, currIndex + 1);
        if (temp.size() > 0) {
            temp.remove(temp.size() - 1);
        }

    }
}