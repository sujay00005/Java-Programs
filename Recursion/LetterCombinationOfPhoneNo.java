package Recursion;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNo {
    public static ArrayList<ArrayList<Character>> digitMap = new ArrayList<ArrayList<Character>>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of key presses present");

        int n = input.nextInt();

        System.out.println("Enter the keypresses except 1");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        // Vector<Vector<Character>> digitMap = new Vector<Vector<Character>>();

        // ArrayList<Character> temp = new ArrayList<Character>(List.of('a','b','c'));
        digitMap.add(new ArrayList<Character>(List.of('a', 'b', 'c')));
        digitMap.add(new ArrayList<Character>(List.of('d', 'e', 'f')));
        digitMap.add(new ArrayList<Character>(List.of('g', 'h', 'i')));
        digitMap.add(new ArrayList<Character>(List.of('j', 'k', 'l')));
        digitMap.add(new ArrayList<Character>(List.of('m', 'n', 'o')));
        digitMap.add(new ArrayList<Character>(List.of('p', 'q', 'r', 's')));
        digitMap.add(new ArrayList<Character>(List.of('t', 'u', 'v')));
        digitMap.add(new ArrayList<Character>(List.of('w', 'x', 'y', 'z')));

        // temp.add('a');
        // temp.add('b');
        // temp.add('c');

        // letterComb(digitMap);

    }

    void printAllCombs(char[] temp, char[] digit, int i, ArrayList<ArrayList<Character>> digigMap) {
        if (i > digit.length - 1) {
            for (int j = 0; j < digit.length; j++) {
                System.out.print(temp[i]);
                return;
            }
        }
        for (int j = 0; j < digitMap.get(digit[i] - 2).size(); j++) {
            // temp[i] = digigMap.get(i - 2)[j];
            printAllCombs(temp, digit, i + 1, digigMap);
        }

    }
}
