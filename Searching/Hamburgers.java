package Searching;

import java.util.Scanner;

public class Hamburgers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // System.out.println("Enter the number of test cases present");
        int t = 1;
        // input.nextInt();

        String[] s = new String[t];
        int[] nB = new int[t];
        int[] nS = new int[t];
        int[] nC = new int[t];
        int[] pB = new int[t];
        int[] pS = new int[t];
        int[] pC = new int[t];
        int[] r = new int[t];

        // s[0] = input.nextLine(); // just beacause 1st string line is skipped while
        // scanning

        // for (int i = 0; i < t; i++) {

        System.out
                .println("*   Enter the string containing B S C where ingredients are from top to bottom   *");
        s[0] = input.nextLine();
        System.out.println("Enter the number of pieces of B S C are present in the kitchen");
        nB[0] = input.nextInt();
        nS[0] = input.nextInt();
        nC[0] = input.nextInt();
        System.out.println("Enter the price of B S C ");
        pB[0] = input.nextInt();
        pS[0] = input.nextInt();
        pC[0] = input.nextInt();

        System.out.println("Enter the number of Rubles(money) the buyer has");
        r[0] = input.nextInt();
        // }

        input.close();
        // for (int i = 0; i < t; i++) {
        System.out.println(hamburgers(s[0], nB[0], nS[0], nC[0], pB[0], pS[0], pC[0], r[0]));
        // }
    }

    public static int hamburgers(String recipe, int nB, int nS, int nC, int pB, int pS, int pC, int rubel) {
        int l = 0, h;
        if (pB < pS && pB < pC)
            h = rubel / pB + nB;
        else if (pS < pB && pS < pC)
            h = rubel / pS + nS;
        else
            h = rubel / pC + nC;

        int m;

        while (l <= h) {
            m = (l + h) / 2;

            boolean r = greedy(recipe, m, nB, nS, nC, pB, pS, pC, rubel);
            if (!r)
                h = m - 1;
            else {
                boolean r1 = greedy(recipe, m + 1, nB, nS, nC, pB, pS, pC, rubel);
                if (!r1)
                    return m;
                else
                    l = m + 1;
            }
        }
        return 0;
    }

    public static boolean greedy(String recipe, int m, int nB, int nS, int nC, int pB, int pS, int pC, int rubel) {
        int countB = 0, countS = 0, countC = 0;

        for (int i = 0; i < recipe.length(); i++) {
            if (recipe.charAt(i) == 'B')
                countB++;
            else if (recipe.charAt(i) == 'S')
                countS++;
            else
                countC++;
        }

        int moneyB = countB == 0 ? 0 : (((m * countB) - nB) * pB);
        int moneyS = countS == 0 ? 0 : (((m * countS) - nS) * pS);
        int moneyC = countC == 0 ? 0 : (((m * countC) - nC) * pC);

        int reqMoney = moneyB + moneyS + moneyC;

        return rubel >= reqMoney;
    }

}
