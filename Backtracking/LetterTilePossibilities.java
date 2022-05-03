package Backtracking;

import java.util.HashMap;
import java.util.Scanner;

public class LetterTilePossibilities {
    public static HashMap<String, Integer> hMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the length input tiles");
        int n = input.nextInt();

        System.out.println("Enter the letters present on each printed tile");
        char letters[] = input.next().toCharArray();

        wordsPossibility(letters, 0);
        System.out.println(hMap);

    }

    public static void wordsPossibility(char[] letters, int currentLength) {
        if (currentLength == letters.length)
            return;

        String s = "";
        for (int i = 0; i < letters.length; i++) {
            s += letters[i];
            hMap.put(s, 1);
            for (int j = 0; j < s.length(); j++) {

            }
            wordsPossibility(letters, currentLength + 1);
        }
    }

    public static void premutation(int[] a, int currPosition) {
        if (currPosition == a.length - 1) {
            for (int i = 0; i < a.length; i++) {
                // hMap.put(a[i], value)
                System.out.print(a[i]);
            }
            System.out.println("");
            return;
        }
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = currPosition; i < a.length; i++) {
            if (freq.get(a[i]) == null) {
                // swap
                int temp = a[currPosition];
                a[currPosition] = a[i];
                a[i] = temp;
                premutation(a, currPosition + 1);
                // unswap
                temp = a[currPosition];
                a[currPosition] = a[i];
                a[i] = temp;
            }
            freq.put(a[i], 1);
        }

    }
}
