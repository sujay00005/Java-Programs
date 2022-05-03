package Recursion;

import java.util.Scanner;

public class PowerOfXToN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the value of base");
        double base = input.nextDouble();

        System.out.println("Enter the value of power");
        int power = input.nextInt();
        input.close();

        double value;
        if (power < 0) {
            value = 1 / pow(base, power);
        } else {
            value = pow(base, power);
        }
        System.out.println(value);
    }

    public static double pow(double base, int power) {
        if (power == 0)
            return 1;
        double x = pow(base, power / 2);
        if (power % 2 == 0)
            return x * x;
        return x * x * base;
    }
}

/// For finding power of int base and power
// public static int pow(int power, int base){
// if(power == 0) return 1;
// int x = pow(power/2, base);
// if(power%2==0) return x*x;
// return x*x*base;
// }