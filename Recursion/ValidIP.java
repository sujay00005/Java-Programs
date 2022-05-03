package Recursion;

import java.util.Scanner;

public class ValidIP {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the string out of which valid IP is to be found");

        String str = input.nextLine();
        // char[] str = input.next().toCharArray();
        int n = str.length();
        input.close();
        findValidIP(str, n);

    }

    public static void findValidIP(String s, int length) {
        int count = 0;
        for (int i = 1; count < 4; i++) {
            count++;
            int k = i + 1;
            while (k < i + 4 && k < length) {

                int l = k + 1;
                while (l < k + 4 && l < length) {

                    if (length - 1 - l > 3)
                        continue;
                    if (isValid(s, 0, i) &&
                            isValid(s, i, k) &&
                            isValid(s, k, l) &&
                            isValid(s, l, length)) {
                        System.out.println(s.substring(0, i) + "." +
                                s.substring(i, k) + "."
                                + s.substring(k, l) + "." +
                                s.substring(l, length));
                    }
                    l++;
                }
                k++;
            }
        }
    }

    public static boolean isValid(String s, int start, int end) {
        int temp = 0;
        String test = s.substring(start, end);
        if (test == "")
            return false;
        try {
            temp = Integer.parseInt(test);
            if (temp >= 0 && temp <= 225) {
                int countDigits = 0;
                if (temp > 0) {
                    while (temp > 0) {
                        countDigits++;
                        temp /= 10;
                    }
                } else if (temp == 0) {
                    countDigits = 1;
                }
                if (countDigits == test.length() && temp >= 0 && temp <= 225)
                    return true;
            } else
                return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return false;
    }
}
