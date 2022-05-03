package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PalindromePartition {
    public static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the string whose palindrome partition is to be found");
        String s = input.nextLine();

        // input.close();
        pPartition(s, 1);
        System.out.println(map);
    }

    public static void pPartition(String s, int subStringSize) {
        if (subStringSize == s.length())
            return;

        String temp = "";
        ArrayList<Character> t = new ArrayList<>();
        int k = 0;
        for (int i = k; i <= subStringSize - 1; i++) {
            k++;
            t.add(s.charAt(i));
            temp += s.charAt(i);
        }

        System.out.println(k + "*********");
        if (palindrome(temp))
            map.put(temp, 1);
        for (int i = k; i < s.length(); i += subStringSize) {
            k++;
            System.out.println(t.size() + "     " + i + "     " + subStringSize);
            t.remove(i - subStringSize);
            t.add(s.charAt(i));
            temp = "";
            for (int j = 0; j < t.size(); j++) {
                temp += t.get(j);
            }

        }
        pPartition(s, subStringSize - 1);

    }

    public static boolean palindrome(String s) {
        String temp = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            temp += s.charAt(i);
        }
        if (!temp.contains(s))
            return false;
        return true;
    }
}
