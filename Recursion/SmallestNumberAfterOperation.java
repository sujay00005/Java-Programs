package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class SmallestNumberAfterOperation {
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the 4 numbers on which operation was performed");

        ArrayList<Integer> num = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            num.add(input.nextInt());
        }

        System.out.println("Enter the sequence of 3 operations(+ or *)");
        // input of char array [eg input: +*+]

        char[] operation = input.next().toCharArray();
        input.close();

        minVal(num, operation);
        System.out.println(min);
    }

    public static void minVal(ArrayList<Integer> num, char[] operation) {
        if (num.size() == 1) {
            min = minimum(min, num.get(0));
            System.out.println(min + " ***************");
            return;
        }

        for (int i = 0; i < num.size(); i++) {
            for (int j = i + 1; j < num.size(); j++) {
                int operationIndex = 4 - num.size();
                int operationValue = performOperation(num, operation[operationIndex], i, j);
                num.set(i, operationValue);
                num.remove(j);
                minVal(num, operation);
            }
        }
    }

    public static int performOperation(ArrayList<Integer> num, char operation, int i, int j) {
        if (operation == '*')
            return num.get(i) * num.get(j);
        else if (operation == '+')
            return num.get(i) + num.get(j);
        return 0;
    }

    public static int minimum(int a, int b) {
        if (a <= b)
            return a;
        return b;
    }
}