package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShiftPilesOfPlates {
    public static int count = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of number of plates present ");
        int N = input.nextInt();
        System.out.println("Enter the value of move required to print");
        int n = input.nextInt();
        // input.close();

        char bucket1 = '1', bucket2 = '2', bucket3 = '3';
        // if (N % 2 == 0)
        // startBucket = 2;
        // else
        // startBucket = 3;
        // ArrayList<Integer> stepList = new ArrayList<Integer>(List.of(0));
        shiftPile(N, n, bucket1, bucket2, bucket3);
    }

    public static void shiftPile(int N, int n, char bucket1, char bucket2, char bucket3) {
        if (N == 0) {
            System.out.println("");
            return;
        }

        shiftPile(N - 1, n, bucket1, bucket2, bucket3);
        if (N == n) {
            System.out.println("Move disk " + n + " from " + bucket1 + " to " + bucket3);
            return;
        }

        shiftPile(N - 1, n, bucket2, bucket3, bucket1);

    }
}
