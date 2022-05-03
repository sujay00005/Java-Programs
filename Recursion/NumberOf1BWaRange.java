package Recursion;

import java.util.LinkedList;
import java.util.Scanner;

public class NumberOf1BWaRange {
    static LinkedList<Integer> a = new LinkedList<Integer>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number");
        int n = input.nextInt();

        System.out.println("Enter the value of l and r");
        int l = input.nextInt();
        int r = input.nextInt();
        input.close();

        a.add(n);
        numberOfOnes(false, l, r);
    }

    public static void numberOfOnes(boolean flag, int l, int r) {
        System.out.println(a + "   ******************");
        if (flag) {
            int count = 0;
            if (r > a.size())
                r = a.size();
            for (int i = l; i < r + 1; i++) {
                if (a.get(i) == 1)
                    count++;
            }
            System.out.println(count);
            return;
        }

        int arrCurrSize = a.size();
        for (int i = 0; i < arrCurrSize; i++) {
            if (a.get(i) > 1) {
                int temp = a.get(i);

                a.set(i, temp / 2);
                a.add(i + 1, temp % 2);
                a.add(i + 2, temp / 2);

            }
        }

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > 1)
                break;
            if (i == a.size() - 1)
                flag = true;
        }
        numberOfOnes(flag, l, r);
    }
}
