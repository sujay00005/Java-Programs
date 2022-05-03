package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class SequentialDigit {
    public static int maxDigit = 0;
    public static int minDigit = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of low and high");
        int low = input.nextInt();
        int high = input.nextInt();

        input.close();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        minDigit = numberOfDigits(low);
        maxDigit = numberOfDigits(high);
        sequentialDigit(low, high, temp);
    }

    public static void sequentialDigit(int low, int high, ArrayList<Integer> temp) {
        if (low >= high) {
            System.out.println(temp);
            return;
        }

        temp.add(generateNumber(low));

        // first digit of current low in n
        int n = low;
        int numbersAfterFirstDigit = 0;
        while (n >= 10) {
            n /= 10;
            numbersAfterFirstDigit++;
        }

        // if last digit of the number to be generated is > 9
        if (n + 1 + numbersAfterFirstDigit > 9) {
            n = 0;
            numbersAfterFirstDigit += 1;
        }
        low = (n + 1) * (int) Math.pow(10, numbersAfterFirstDigit);
        sequentialDigit(low, high, temp);

    }

    public static int generateNumber(int num) {
        // first digit of number
        int n = num;
        while (n >= 10) {
            n /= 10;
        }
        int noDigits = numberOfDigits(num);
        int numberToReturn = 0;
        while (noDigits > 0) {
            numberToReturn = numberToReturn * 10 + n;
            n++;
            noDigits--;
        }

        return numberToReturn;
    }

    public static int numberOfDigits(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

}
