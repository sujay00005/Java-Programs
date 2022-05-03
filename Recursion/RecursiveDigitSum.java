package Recursion;

import java.util.Scanner;

public class RecursiveDigitSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number whose recursive sum is to be found");
        String num = input.nextLine();

        System.out.println("Enter the value of 'k'");
        int k = input.nextInt();

        int n = Integer.parseInt(num);

        input.close();

        superDigit(n, k);
    }

    public static void superDigit(int n, int k) {
        if (n / 10 == 0) { // ie single digit number
            System.out.println("super sum " + n);
            return;
        }
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }

        if (k > 1) {
            sum *= k;
            k = 1;
        }
        superDigit(sum, k);
    }
}

/// OTHER METHOD OF SOLVING
// String temp="";
// for(int i=0; i<k; i++){
// temp = temp+num;
// }

// long n = Long.parseLong(temp);

// input.close();

// superDigit(n);
// }

// public static void superDigit(long n){
// if(n/10==0){
// System.out.println("super sum "+ n);
// return;
// }
// int sum = 0;

// while (n>0) {
// sum += n%10;
// n = n/10;
// }
// sum += n;
// superDigit(sum);
// }
// }
