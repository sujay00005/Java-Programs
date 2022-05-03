//Maximize the expression p·ai + q·aj + r·ak  (where i <= j <= k)

import java.util.Scanner;

public class Week1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size of array n and value of p,q,r.");
        int size = input.nextInt();
        int p = input.nextInt();
        int q = input.nextInt();
        int r = input.nextInt();

        System.out.println("Enter the array. ");
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = input.nextInt();
        }

        input.close();

        int[] pMax = new int[size];
        int[] sMax = new int[size];

        pMax[0] = a[0] * p;

        for (int i = 1; i <= size - 1; i++) {
            int temp1 = p * a[i];
            if (pMax[i - 1] > temp1)
                pMax[i] = pMax[i - 1];
            else if (pMax[i - 1] < temp1)
                pMax[i] = temp1;
            // System.out.println(pMax[i]);
        }

        sMax[size - 1] = a[size - 1] * r;

        for (int j = size - 2; j >= 0; j--) {
            int temp2 = r * a[j];
            if (sMax[j + 1] > temp2)
                sMax[j] = sMax[j + 1];
            else if (sMax[j + 1] < temp2)
                sMax[j] = temp2;
            // System.out.println(sMax[j]);
        }

        int answer = Integer.MIN_VALUE;
        for (int k = 0; k <= size - 1; k++) {
            int equation = (pMax[k] + q * a[k] + sMax[size - 1 - k]);
            if (answer < equation) {
                answer = equation;
                // System.out.println(answer);
            }
        }

        System.out.println(answer);

    }
}
