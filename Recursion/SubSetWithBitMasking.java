package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class SubSetWithBitMasking {
    public static int noOfBits;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of elements present in the array");
        int n = input.nextInt();

        System.out.println("Enter the elements present in the array");
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        input.close();

        int len = (int) (Math.pow(2, n));
        System.out.println(len + "===== Combs possible");

        // position in temp array
        for (int i = 0; i < len; i++) {
            System.out.println("");
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int k = BitRep(i);
            int indexInTemp = 0;
            int currIndexInArray = 0;
            while (k > 0) {
                if (k % 10 == 1) {
                    temp.add(indexInTemp++, a[currIndexInArray]);
                }
                k = k / 10;
                currIndexInArray++;
            }
            for (int j : temp) {
                System.out.print(j);
            }
        }
    }

    public static int BitRep(int i) {
        int l = 0;
        int place = 1;
        int numberOfBits = 0;
        while (i != 0) {
            numberOfBits++;
            l = l + (i % 2) * place;
            i = i / 2;
            place = place * 10;
        }
        noOfBits = numberOfBits;
        // System.out.println(l);
        return l;
    }
}
