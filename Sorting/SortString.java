package Sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SortString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the order string");
        String order = input.nextLine();

        System.out.println("Enter the string which is to be sorted according to the order string");
        String s = input.nextLine();

        input.close();

        int[] rank = new int[26];
        Arrays.fill(rank, Integer.MAX_VALUE);

        for (int i = 0; i < order.length(); i++)
            rank[order.charAt(i) - 'a'] = i;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), rank[s.charAt(i) - 'a']);

        char newString[] = new char[s.length()];

        for (Map.Entry<Character, Integer> mapElement : map.entrySet()) {
            try {
                // System.out.println(mapElement.getKey() + " " + (int) mapElement.getValue());
                newString[(int) mapElement.getValue()] = (char) mapElement.getKey();
            } catch (Exception e) {
                break;
            }
        }

        String a = "";
        for (int i = 0; i < newString.length; i++) {
            a = a + newString[i];
        }
        // System.out.println(s);

        for (int i = 0; i < s.length(); i++) {
            if (!contains(a, s.charAt(i))) {
                a += s.charAt(i);
            }
        }

        System.out.println(a);

    }

    public static boolean contains(String a, char k) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == k)
                return true;
        }
        return false;
    }
}
