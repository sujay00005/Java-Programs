package Searching;

import java.util.Scanner;

public class SmallestGoodBase {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of test cases present");
        int n = input.nextInt();

        System.out.println("Enter the elements present in all these test cases");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        input.close();
        for (int i = 0; i < n; i++) {
            System.out.println(goodBase(a[i]));
        }

    }

    public static int goodBase(int a) {

        for (int i = 63; i >= 1; i--) { // for no of digits present in good base
            int l = 2, h = a - 1, m;
            while (l <= h) {
                m = (l + h) / 2;
                int val = 0; // sum of powers
                int x = 1; // value of next power
                int flag = 0;

                for (int j = 0; j <= i; j++) { // for calculating powers
                    val += x;
                    if (val >= a) // if val of sum of powers exceed original value
                        break;
                    if (j < i && (a - val) / x < m) { // if val of sum of next poweris going to exceed original value
                                                      // but calculating the value will cause integer overflow
                        flag = 1;
                        break;
                    }
                    if (j < i) // if j hasn't reached max and also haven't attained the value of original
                               // number
                        x *= m; // so calculating value of next power
                }
                if (val > a || flag == 1)
                    h = m - 1;
                else if (val < a)
                    l = m + 1;
                else
                    return m;
            }
        }
        return -1;
    }
}
