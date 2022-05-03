package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransformFromAtoB {
    public static int count = 0;
    public static boolean flag = false;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a, b;
        System.out.println("Enter the numbers to transform from 'a' to 'b'");
        a = input.nextInt();
        b = input.nextInt();
        input.close();

        boolean flag = false;
        List<Integer> stack = new ArrayList<Integer>();
        int steps = 0;
        transform(a, b, flag, steps, stack);
        if (!flag)
            System.out.println("NO");
    }

    public static void transform(int a, int finalValue, boolean flag, int steps, List<Integer> stack) {
        if (a >= finalValue) {
            if (a == finalValue) {
                System.out.println("YES");
                flag = true;
                System.out.println(steps);
                System.out.println(stack);
            }
            return;
        }

        stack.add(2 * a);
        transform(2 * a, finalValue, flag, steps + 1, stack);
        a /= 2;
        stack.remove(steps);
        stack.add((10 * a) + 1);
        transform((10 * a) + 1, finalValue, flag, steps + 1, stack);
        a = (a - 1) / 10;
        steps--;
        if (steps >= 0) {
            stack.remove(steps);
        }
    }
}
