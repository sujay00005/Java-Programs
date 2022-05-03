package Recursion;

import java.util.Scanner;

public class KthHappyLexicographicString {
    public static int count = 0;
    public static char[] happyLetter = { 'a', 'b', 'c' };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of length of the happy string");
        int n = input.nextInt();

        System.out.println("Enter the value of k to return the kth string");
        int k = input.nextInt();

        input.close();
        char[] formedString = new char[n];
        int nth = 0;
        generateString(n, k, formedString, nth);
        if (count < k) {
            System.out.println("\"\"");
        }
    }

    public static void generateString(int n, int k, char[] formedString, int nth) {
        if (nth == n) {
            count++;
            if (count == k)
                System.out.println(formedString);
            return;
        }
        if (nth != 0) {
            for (int i = 0; i < 3; i++) {
                if (formedString[nth - 1] != happyLetter[i % 3]) {
                    formedString[nth] = happyLetter[i % 3];
                    generateString(n, k, formedString, nth + 1);
                }
            }

        } else if (nth == 0) {
            for (int i = 0; i < 3; i++) {
                formedString[nth] = happyLetter[i % 3];
                generateString(n, k, formedString, nth + 1);
            }
        }
    }
}

// THIS DOES THE SAME THING AS THE FOR LOOP

// if (formedString[nth - 1] != 'a') {
// formedString[nth] = 'a';
// generateString(n, k, formedString, nth + 1);
// }
// if (formedString[nth - 1] != 'b') {
// formedString[nth] = 'b';
// generateString(n, k, formedString, nth + 1);
// }
// if (formedString[nth - 1] != 'c') {
// formedString[nth] = 'c';
// generateString(n, k, formedString, nth + 1);
// }
// }